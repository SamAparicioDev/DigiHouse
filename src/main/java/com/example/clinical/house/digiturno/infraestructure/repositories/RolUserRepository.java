package com.example.clinical.house.digiturno.infraestructure.repositories;

import com.example.clinical.house.digiturno.infraestructure.entities.RolUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RolUserRepository extends JpaRepository<RolUser, UUID> {
}
