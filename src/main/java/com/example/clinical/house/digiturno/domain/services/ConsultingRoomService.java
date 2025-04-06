package com.example.clinical.house.digiturno.domain.services;

import com.example.clinical.house.digiturno.aplication.dtos.ConsultingRoomDTO;
import com.example.clinical.house.digiturno.infraestructure.entities.ConsultingRoom;

import java.util.List;
import java.util.UUID;

public interface ConsultingRoomService {
    List<ConsultingRoom> getAllConsultingRooms();

    public List<ConsultingRoom> getConsultingRoomsByHeadquarter(UUID headquarterId);

    ConsultingRoom getConsultingRoomById(UUID id);

    ConsultingRoom saveConsultingRoom(ConsultingRoomDTO consultingRoom);

    ConsultingRoom updateConsultingRoomById(UUID id, ConsultingRoomDTO consultingRoomDTO);

    void deleteConsultingRoomById(UUID id);

}
