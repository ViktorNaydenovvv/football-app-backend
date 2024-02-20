package com.example.diplomaprojectbackend.service.impl;

import com.example.diplomaprojectbackend.controller.resource.FootballerResource;
import com.example.diplomaprojectbackend.entity.Footballer;
import com.example.diplomaprojectbackend.repository.FootballerRepository;
import com.example.diplomaprojectbackend.service.FootballerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.diplomaprojectbackend.mapper.FootballerMapper.FOOTBALLER_MAPPER;

@Service
@RequiredArgsConstructor
public class FootballerServiceImpl implements FootballerService {
    private final FootballerRepository footballerRepository;

    @Override
    public List<FootballerResource> findAll() {
        return FOOTBALLER_MAPPER.toFootballerResources(footballerRepository.findAll());
    }

    @Override
    public FootballerResource getById(Long id) {
        Footballer footballer = footballerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Unable to find footballer with id " + id + "!"));

        return FOOTBALLER_MAPPER.toFootballerResource(footballer);
    }

    @Override
    public FootballerResource save(FootballerResource footballerResource) {
        return FOOTBALLER_MAPPER.toFootballerResource(footballerRepository.save(FOOTBALLER_MAPPER.fromFootballerResource(footballerResource)));
    }

    @Override
    public FootballerResource update(Long id, FootballerResource footballerResource) {
        Footballer footballer = footballerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Footballer with id " + id + " not found"));

        footballer.setTeamName(footballerResource.getTeamName());
        footballer.setPosition(footballerResource.getPosition());
        footballer.setPace(footballerResource.getPace());
        footballer.setShooting(footballerResource.getShooting());
        footballer.setPassing(footballerResource.getPassing());
        footballer.setDribbling(footballerResource.getDribbling());
        footballer.setPhysique(footballerResource.getPhysique());
        footballer.setDefending(footballerResource.getDefending());
        footballer.setWeakFoot(footballerResource.getWeakFoot());
        footballer.setSkillMoves(footballerResource.getSkillMoves());

        return FOOTBALLER_MAPPER.toFootballerResource(footballerRepository.save(footballer));
    }

    @Override
    public void delete(Long id) {
        if(footballerRepository.existsById(id)) {
            footballerRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Unable to find footballer with id " + id + "!");
        }
    }

}
