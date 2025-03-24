package com.example.clinical.house.digiturno.aplication.dtos;

import com.example.clinical.house.digiturno.infraestructure.entities.ConsultingRoom;
import com.example.clinical.house.digiturno.infraestructure.entities.Module;

public record GeneralUserDTO(Long nit, String name, String lastName, UserState userState
                            , Module module, ConsultingRoom consultingRoom) {

}

