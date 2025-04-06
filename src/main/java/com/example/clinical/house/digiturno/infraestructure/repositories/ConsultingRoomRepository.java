package com.example.clinical.house.digiturno.infraestructure.repositories;

import com.example.clinical.house.digiturno.infraestructure.entities.ConsultingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ConsultingRoomRepository extends JpaRepository<ConsultingRoom, UUID> {
    @Query("SELECT c FROM ConsultingRoom c WHERE c.headquarter.id = :headquarterId")
    List<ConsultingRoom> findByHeadquarterId(@Param("headquarterId") UUID headquarterId);

}
