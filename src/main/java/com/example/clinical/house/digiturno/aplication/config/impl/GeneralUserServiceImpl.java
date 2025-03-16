package com.example.clinical.house.digiturno.aplication.config.impl;

import com.example.clinical.house.digiturno.aplication.config.exceptions.generalUser.GeneralUserNotFoundException;
import com.example.clinical.house.digiturno.aplication.dtos.GeneralUserDTO;
import com.example.clinical.house.digiturno.aplication.dtos.UserState;
import com.example.clinical.house.digiturno.domain.mapper.GeneralUserMapper;
import com.example.clinical.house.digiturno.domain.services.GeneralUserService;
import com.example.clinical.house.digiturno.infraestructure.entities.GeneralUser;
import com.example.clinical.house.digiturno.infraestructure.entities.Module;
import com.example.clinical.house.digiturno.infraestructure.entities.ReceptionistUser;
import com.example.clinical.house.digiturno.infraestructure.repositories.GeneralUserRepository;
import com.example.clinical.house.digiturno.infraestructure.repositories.ModuleRepository;
import com.example.clinical.house.digiturno.infraestructure.repositories.ReceptionistUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class GeneralUserServiceImpl implements GeneralUserService {
    @Autowired
    private GeneralUserRepository generalUserRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private ReceptionistUserRepository receptionistUserRepository;
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
                Module module = moduleRepository.findById(generalUser.module().getModuleId()).orElseThrow();
                ReceptionistUser receptionistUser = receptionistUserRepository.findById(generalUser.receptionistUser().getReceptionistUserId()).orElseThrow();
       return generalUserRepository.save(new GeneralUser(generalUser.id(),generalUser.nit(),generalUser.name(),generalUser.lastName(),generalUser.userState(),
               receptionistUser,module));
    }

    @Override
    public GeneralUser updateGeneralUserState(UUID id, UserState userState) {
        GeneralUser generalUserFound = generalUserRepository.getReferenceById(id);
        generalUserFound.setState(userState);
        return generalUserRepository.save(generalUserFound);
    }

    @Override
    public void deleteGeneralUser(UUID id) {
         generalUserRepository.deleteById(id);
    }
}
