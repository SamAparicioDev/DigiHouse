package com.example.clinical.house.digiturno.aplication.config.impl;

import com.example.clinical.house.digiturno.aplication.config.exceptions.generalUser.GeneralUserNotFoundException;
import com.example.clinical.house.digiturno.aplication.dtos.GeneralUserDTO;
import com.example.clinical.house.digiturno.domain.mapper.GeneralUserMapper;
import com.example.clinical.house.digiturno.domain.services.GeneralUserService;
import com.example.clinical.house.digiturno.infraestructure.entities.GeneralUser;
import com.example.clinical.house.digiturno.infraestructure.repositories.GeneralUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class GeneralUserServiceImpl implements GeneralUserService {
    @Autowired
    private GeneralUserRepository generalUserRepository;
    @Override
    public List<GeneralUser> listAllGeneralUsers() {
        return generalUserRepository.findAll();
    }

    @Override
    public GeneralUser getGeneralUserById(UUID id) {
        return generalUserRepository.findById(id).orElseThrow(() -> new GeneralUserNotFoundException("User Not Found"));
    }

    @Override
    public GeneralUser createGeneralUser(GeneralUserDTO generalUser) {
       return generalUserRepository.save(GeneralUserMapper.generalUserDtoToGeneralUser(generalUser));
    }

    @Override
    public GeneralUser updateGeneralUser(UUID id,GeneralUserDTO generalUser) {
        GeneralUser generalUserFound = generalUserRepository.getReferenceById(id);
        return generalUserRepository.save(GeneralUserMapper.generalUserDtoUpdate(generalUserFound, generalUser));
    }

    @Override
    public void deleteGeneralUser(UUID id) {
         generalUserRepository.deleteById(id);
    }
}
