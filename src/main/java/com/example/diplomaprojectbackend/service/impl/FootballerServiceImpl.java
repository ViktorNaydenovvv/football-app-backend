package com.example.diplomaprojectbackend.service.impl;

import com.example.diplomaprojectbackend.controller.resource.CreateFootballerReq;
import com.example.diplomaprojectbackend.controller.resource.FetchFootballersFilters;
import com.example.diplomaprojectbackend.entity.Footballer;
import com.example.diplomaprojectbackend.repository.FootballerRepository;
import com.example.diplomaprojectbackend.service.FootballerService;
import com.example.diplomaprojectbackend.shared.exception.DuplicateEntityFieldException;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.diplomaprojectbackend.mapper.FootballerMapper.FOOTBALLER_MAPPER;

@Service
@RequiredArgsConstructor
public class FootballerServiceImpl implements FootballerService {
    private final FootballerRepository footballerRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    @Override
    public void save(CreateFootballerReq createFootballerReq) {
        try {
            createFootballerReq.getProfileData().setPassword(passwordEncoder.encode(createFootballerReq.getProfileData().getPassword()));
            Footballer footballer = FOOTBALLER_MAPPER.fromCreateFootballerReq(createFootballerReq);
            footballerRepository.save(footballer);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEntityFieldException("Footballer with this email already exists");
        }
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
}
