package com.example.clinical.house.digiturno.aplication.config.impl;

import com.example.clinical.house.digiturno.aplication.dtos.ConsultingRoomDTO;
import com.example.clinical.house.digiturno.domain.services.ConsultingRoomService;
import com.example.clinical.house.digiturno.infraestructure.entities.ConsultingRoom;
import com.example.clinical.house.digiturno.infraestructure.entities.Headquarter;
import com.example.clinical.house.digiturno.infraestructure.repositories.ConsultingRoomRepository;
import com.example.clinical.house.digiturno.infraestructure.repositories.HeadquarterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultingRoomServiceImpl implements ConsultingRoomService {

    @Autowired
    private ConsultingRoomRepository consultingRoomRepository;

    @Autowired
    private HeadquarterRepository headquarterRepository;

    @Override
    public List<ConsultingRoom> getAllConsultingRooms() {
        return consultingRoomRepository.findAll();
    }

    @Override
    public List<ConsultingRoom> getConsultingRoomsByHeadquarter(UUID headquarterId) {
        return consultingRoomRepository.findByHeadquarterId(headquarterId);
    }

    @Override
    public ConsultingRoom getConsultingRoomById(UUID id) {
        return consultingRoomRepository.findById(id).orElse(null);
    }

    @Override
    public ConsultingRoom saveConsultingRoom(ConsultingRoomDTO consultingRoomDTO) {
        Headquarter headquarter = headquarterRepository.findById(consultingRoomDTO.headquarterId())
                .orElseThrow(() -> new RuntimeException("Sede no encontrada"));

        ConsultingRoom consultingRoom = new ConsultingRoom(consultingRoomDTO.name(), headquarter);
        return consultingRoomRepository.save(consultingRoom);
    }

    @Override
    public ConsultingRoom updateConsultingRoomById(UUID id, ConsultingRoomDTO consultingRoomDTO) {
        ConsultingRoom consultingRoom = consultingRoomRepository.findById(id).orElseThrow(null);
        consultingRoom.setName(consultingRoomDTO.name());
        return consultingRoomRepository.save(consultingRoom);
    }

    @Override
    public void deleteConsultingRoomById(UUID id) {
        consultingRoomRepository.deleteById(id);
    }
}
