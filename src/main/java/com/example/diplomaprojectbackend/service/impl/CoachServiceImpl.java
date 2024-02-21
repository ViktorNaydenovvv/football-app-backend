package com.example.diplomaprojectbackend.service.impl;

import com.example.diplomaprojectbackend.controller.resource.CreateCoachReq;
import com.example.diplomaprojectbackend.controller.resource.FetchCoachesFilters;
import com.example.diplomaprojectbackend.entity.Coach;
import com.example.diplomaprojectbackend.repository.CoachRepository;
import com.example.diplomaprojectbackend.service.CoachService;
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

import static com.example.diplomaprojectbackend.mapper.CoachMapper.COACH_MAPPER;

@Service
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService {
    private final CoachRepository coachRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    @Override
    public void save(CreateCoachReq createCoachReq) {
        try {
            createCoachReq.getProfileData().setPassword(passwordEncoder.encode(createCoachReq.getProfileData().getPassword()));
            Coach coach = COACH_MAPPER.fromCreateCoachReq(createCoachReq);
            coachRepository.save(coach);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEntityFieldException("Coach with this email already exists");
        }
    }

    private Specification<Coach> buildSpecification(FetchCoachesFilters filters) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (filters.getTeamName() != null && !filters.getTeamName().isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("teamName"), filters.getTeamName()));
            }

            return predicate;
        };
    }

    @Override
    public Page<Coach> fetch(FetchCoachesFilters filters, Pageable pageable) {
        Specification<Coach> spec = buildSpecification(filters);
        return coachRepository.findAll(spec, pageable);
    }
}
