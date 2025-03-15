package com.example.clinical.house.digiturno.aplication.config.impl;

import com.example.clinical.house.digiturno.aplication.dtos.ModuleDTO;
import com.example.clinical.house.digiturno.domain.services.ModuleService;
import com.example.clinical.house.digiturno.infraestructure.entities.Module;
import com.example.clinical.house.digiturno.infraestructure.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    private ModuleRepository moduleRepository;
    @Override
    public List<Module> listAll() {
        return moduleRepository.findAll();
    }
    @Override
    public Module saveModule(ModuleDTO moduleDTO){
        return moduleRepository.save(new Module(moduleDTO.name()));
    }

}
