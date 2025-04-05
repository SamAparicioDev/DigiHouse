package com.example.clinical.house.digiturno.infraestructure.repositories;

import com.example.clinical.house.digiturno.infraestructure.entities.GeneralUser;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GeneralUserRepository extends JpaRepository<GeneralUser, UUID> {
    @Query("SELECT u FROM GeneralUser u WHERE u.consultingRoom.consultingRoomId = :consultingRoomId")
    List<GeneralUser> findByConsultingRoomId(@Param("consultingRoomId") UUID consultingRoomId);

    @Query("SELECT u FROM GeneralUser u WHERE u.module.moduleId = :moduleId")
    List<GeneralUser> findByModuleId(@Param("moduleId") UUID moduleId);

    @Query("SELECT g FROM GeneralUser g WHERE g.module IS NOT NULL AND g.consultingRoom IS NULL")
    List<GeneralUser> findAllWithModuleAndNoConsultingRoom();

}
