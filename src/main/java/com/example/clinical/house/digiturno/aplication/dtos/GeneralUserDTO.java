package com.example.clinical.house.digiturno.aplication.dtos;

import com.example.clinical.house.digiturno.infraestructure.entities.ConsultingRoom;
import com.example.clinical.house.digiturno.infraestructure.entities.Module;
import com.example.clinical.house.digiturno.infraestructure.entities.ReceptionistUser;
import com.example.clinical.house.digiturno.infraestructure.entities.RolUser;

import java.util.UUID;

public record GeneralUserDTO(Long nit, String name, String lastName, UserState userState
                            , Module module, RolUser role, ConsultingRoom consultingRoom) {

}

