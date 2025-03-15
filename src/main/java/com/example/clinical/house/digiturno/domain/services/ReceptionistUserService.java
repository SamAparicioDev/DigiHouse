package com.example.clinical.house.digiturno.domain.services;


import com.example.clinical.house.digiturno.aplication.dtos.ReceptionistUserDTO;
import com.example.clinical.house.digiturno.infraestructure.entities.ReceptionistUser;

import java.util.List;
import java.util.UUID;

public interface ReceptionistUserService {
    List<ReceptionistUser> listAllReceptionistUser();
    ReceptionistUser getReceptionistUserById(UUID id);
    ReceptionistUser createReceptionistUser(ReceptionistUserDTO receptionistUserDTO);
    ReceptionistUser updateReceptionistUser(UUID id, ReceptionistUserDTO receptionistUserDTO);
    void deleteReceptionistUser(UUID id);
}
