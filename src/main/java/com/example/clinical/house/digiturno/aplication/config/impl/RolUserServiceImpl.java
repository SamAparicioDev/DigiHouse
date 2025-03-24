package com.example.clinical.house.digiturno.aplication.config.impl;

import com.example.clinical.house.digiturno.aplication.dtos.RolUserDTO;
import com.example.clinical.house.digiturno.domain.services.RolUserService;
import com.example.clinical.house.digiturno.infraestructure.entities.RolUser;
import com.example.clinical.house.digiturno.infraestructure.repositories.RolUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RolUserServiceImpl implements RolUserService {
    @Autowired
    private RolUserRepository rolUserRepository;
    @Override
    public RolUser getById(UUID id) {
        return rolUserRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<RolUser> getAll() {
        return rolUserRepository.findAll();
    }

    @Override
    public RolUser saveRolUser(RolUserDTO rolUser) {
        return rolUserRepository.save(new RolUser(rolUser.name()));
    }

    @Override
    public RolUser updateRolUserById(UUID id, RolUserDTO rolUser) {
        RolUser rolUser1 = rolUserRepository.findById(id).orElseThrow(RuntimeException::new);
        rolUser1.setName(rolUser.name());
        return rolUserRepository.save(rolUser1);
    }

    @Override
    public void deleteRolUserById(UUID id) {
        rolUserRepository.deleteById(id);
    }
}
