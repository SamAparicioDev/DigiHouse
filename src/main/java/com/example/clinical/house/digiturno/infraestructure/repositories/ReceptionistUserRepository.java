package com.example.clinical.house.digiturno.infraestructure.repositories;

import com.example.clinical.house.digiturno.infraestructure.entities.ReceptionistUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ReceptionistUserRepository extends JpaRepository<ReceptionistUser, UUID> {
   Optional<ReceptionistUser> findByUsername(String username);
}
