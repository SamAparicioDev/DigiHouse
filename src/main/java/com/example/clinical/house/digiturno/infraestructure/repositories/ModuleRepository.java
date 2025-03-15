package com.example.clinical.house.digiturno.infraestructure.repositories;

import com.example.clinical.house.digiturno.infraestructure.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModuleRepository extends JpaRepository<Module, UUID> {
}
