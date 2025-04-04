package com.example.clinical.house.digiturno.aplication.dtos;

import com.example.clinical.house.digiturno.infraestructure.entities.ConsultingRoom;
import com.example.clinical.house.digiturno.infraestructure.entities.Module;

import java.util.UUID;

public record GeneralUserDTO(Long nit, String name, String lastName, UserState userState
                            , UUID moduleId, UUID consultingRoomId) {

}

