package com.example.clinical.house.digiturno.aplication.config.impl;

import com.example.clinical.house.digiturno.aplication.dtos.HeadquarterDTO;
import com.example.clinical.house.digiturno.domain.services.HeadquarterService;
import com.example.clinical.house.digiturno.infraestructure.entities.Headquarter;
import com.example.clinical.house.digiturno.infraestructure.repositories.HeadquarterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HeadquarterServiceImpl implements HeadquarterService {

    @Autowired
    private HeadquarterRepository headquarterRepository;

    @Override
    public List<Headquarter> listAllHeadquarter() {
        return headquarterRepository.findAll();
    }

    @Override
    public Headquarter createHeadquarter(HeadquarterDTO headquarterDTO) {
        Headquarter headquarter = new Headquarter();
        headquarter.setName(headquarterDTO.name());
        return headquarterRepository.save(headquarter);
    }


    @Override
    public Headquarter updateHeadquarter(UUID id, Headquarter updatedHeadquarter) {
        return headquarterRepository.findById(id).map(headquarter -> {
            headquarter.setName(updatedHeadquarter.getName());
            return headquarterRepository.save(headquarter);
        }).orElseThrow(() -> new RuntimeException("Headquarter not found"));
    }

    @Override
    public void deleteHeadquarter(UUID id) {
        headquarterRepository.deleteById(id);
    }
}
