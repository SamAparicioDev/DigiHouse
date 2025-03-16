package com.example.clinical.house.digiturno.domain.services;

import com.example.clinical.house.digiturno.aplication.dtos.GeneralUserDTO;
import com.example.clinical.house.digiturno.aplication.dtos.UserState;
import com.example.clinical.house.digiturno.infraestructure.entities.GeneralUser;

import java.util.List;
import java.util.UUID;

public interface GeneralUserService {
    List<GeneralUser> listAllGeneralUsers();
    GeneralUser getGeneralUserById(UUID id);
    GeneralUser createGeneralUser(GeneralUserDTO generalUser);
    GeneralUser updateGeneralUserState(UUID id, UserState userState);
    void deleteGeneralUser(UUID id);
}
