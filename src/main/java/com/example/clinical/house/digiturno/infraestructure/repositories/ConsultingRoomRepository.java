package com.example.clinical.house.digiturno.infraestructure.repositories;

import com.example.clinical.house.digiturno.infraestructure.entities.ConsultingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ConsultingRoomRepository extends JpaRepository<ConsultingRoom, UUID> {
}
