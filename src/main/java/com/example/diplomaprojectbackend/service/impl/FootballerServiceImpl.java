package com.example.diplomaprojectbackend.service.impl;

import com.example.diplomaprojectbackend.controller.resource.CreateFootballerReq;
import com.example.diplomaprojectbackend.controller.resource.FetchFootballersFilters;
import com.example.diplomaprojectbackend.controller.resource.UpdateFootballerReq;
import com.example.diplomaprojectbackend.entity.Footballer;
import com.example.diplomaprojectbackend.repository.FootballerRepository;
import com.example.diplomaprojectbackend.service.AzureBlobService;
import com.example.diplomaprojectbackend.service.FootballerService;
import com.example.diplomaprojectbackend.shared.exception.ActionForbiddenException;
import com.example.diplomaprojectbackend.shared.exception.DuplicateEntityFieldException;
import com.example.diplomaprojectbackend.shared.exception.InvalidIdException;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.example.diplomaprojectbackend.mapper.FootballerMapper.FOOTBALLER_MAPPER;

@Service
@RequiredArgsConstructor
public class FootballerServiceImpl implements FootballerService {
    private final FootballerRepository footballerRepository;
    private final AzureBlobService azureBlobService;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    @Override
    public void save(CreateFootballerReq createFootballerReq) throws IOException {
        final Footballer doesExists = footballerRepository.findByUserEmail(createFootballerReq.getProfileData().getEmail());

        if (doesExists != null) {
            throw new DuplicateEntityFieldException("Footballer with this email already exists");
        }

        //final String photoUrl = azureBlobService.uploadPhoto(photo).join();
        createFootballerReq.getProfileData().setPassword(passwordEncoder.encode(createFootballerReq.getProfileData().getPassword()));

        Footballer footballer = FOOTBALLER_MAPPER.fromCreateFootballerReq(createFootballerReq);
        footballer.getUser().setPhoto("");

        footballerRepository.save(footballer);
    }

    private Specification<Footballer> buildSpecification(FetchFootballersFilters filters) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (filters.getPosition() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("position"), filters.getPosition()));
            }

            if (filters.getTeamName() != null && !filters.getTeamName().isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("teamName"), filters.getTeamName()));
            }

            return predicate;
        };
    }

    @Override
    public Page<Footballer> fetch(FetchFootballersFilters filters, Pageable pageable) {
        Specification<Footballer> spec = buildSpecification(filters);
        return footballerRepository.findAll(spec, pageable);
    }

    @Override
    public Footballer getFootballer(Long id) {
        Footballer footballer = footballerRepository.findById(id).orElse(null);

        if (footballer == null) {
            throw new InvalidIdException("Invalid user id = " + id);
        }

        return footballer;
    }

    public Page<Footballer> findByUsername(String username, Pageable pageable) {
        return footballerRepository.findByUserUsernameContaining(username, pageable);
    }

    @Override
    public Footballer updateFootballer(Long id, UpdateFootballerReq footballerData, String email) {
        Footballer footballer = getFootballer(id);

        if (!footballer.getUser().getEmail().equals(email)) {
            throw new ActionForbiddenException("Action forbidden");
        }

        footballer.setTeamName(footballerData.getTeamName());
        footballer.setPosition(footballerData.getPosition());
        footballer.setPace(footballerData.getPace());
        footballer.setShooting(footballerData.getShooting());
        footballer.setPassing(footballerData.getPassing());
        footballer.setDribbling(footballerData.getDribbling());
        footballer.setPhysique(footballerData.getPhysique());
        footballer.setDefending(footballerData.getDefending());
        footballerRepository.save(footballer);

        return footballer;
    }

    @Override
    public void deleteFootballer(Long id, String email) {
        Footballer footballer = getFootballer(id);

        if (!footballer.getUser().getEmail().equals(email)) {
            throw new ActionForbiddenException("Action forbidden");
        }

        footballerRepository.delete(footballer);
        azureBlobService.deletePhoto(footballer.getUser().getPhoto());
    }
}
