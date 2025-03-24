package com.example.clinical.house.digiturno.domain.services;

import com.example.clinical.house.digiturno.aplication.dtos.RolUserDTO;
import com.example.clinical.house.digiturno.infraestructure.entities.RolUser;

import java.util.List;
import java.util.UUID;

public interface RolUserService {
    RolUser getById(UUID id);
    List<RolUser> getAll();
    RolUser saveRolUser(RolUserDTO rolUser);
    RolUser updateRolUserById(UUID id, RolUserDTO rolUser);
    void deleteRolUserById(UUID id);
}
