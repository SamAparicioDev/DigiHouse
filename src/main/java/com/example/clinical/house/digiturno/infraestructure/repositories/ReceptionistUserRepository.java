package com.example.clinical.house.digiturno.infraestructure.repositories;

import com.example.clinical.house.digiturno.infraestructure.entities.ReceptionistUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ReceptionistUserRepository extends JpaRepository<ReceptionistUser, UUID> {
   Optional<ReceptionistUser> findByUsername(String username);
}
