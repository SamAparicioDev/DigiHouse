package com.example.clinical.house.digiturno.aplication.dtos;

import com.example.clinical.house.digiturno.infraestructure.entities.Module;
import com.example.clinical.house.digiturno.infraestructure.entities.ReceptionistUser;

import java.util.UUID;

public record GeneralUserDTO(UUID id, Long nit, String name, String lastName, UserState userState,
                             ReceptionistUser receptionistUser, Module module) {

}

