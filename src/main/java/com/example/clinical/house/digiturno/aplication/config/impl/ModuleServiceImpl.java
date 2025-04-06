package com.example.clinical.house.digiturno.aplication.config.impl;

import com.example.clinical.house.digiturno.aplication.dtos.ModuleDTO;
import com.example.clinical.house.digiturno.domain.services.ModuleService;
import com.example.clinical.house.digiturno.infraestructure.entities.Headquarter;
import com.example.clinical.house.digiturno.infraestructure.entities.Module;
import com.example.clinical.house.digiturno.infraestructure.repositories.HeadquarterRepository;
import com.example.clinical.house.digiturno.infraestructure.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private HeadquarterRepository headquarterRepository;

    @Override
    public List<Module> listAll() {
        return moduleRepository.findAll();
    }

    @Override
    public Module saveModule(ModuleDTO moduleDTO) {
        Headquarter headquarter = null;

        if (moduleDTO.headquarterId() == null) {
            throw new RuntimeException("Headquarter ID is required");
        }

        headquarter = headquarterRepository.findById(moduleDTO.headquarterId())
                .orElseThrow(() -> new RuntimeException("Headquarter Not Found"));

        return moduleRepository.save(new Module(moduleDTO.name(), headquarter));

    }

    @Override
    public List<Module> getModuleByHeadquarterId(UUID headquarterId) {
        if (headquarterId != null) {
            return moduleRepository.findByHeadquarterId(headquarterId);
        } else {
            return moduleRepository.findAll();
        }
    }

}
