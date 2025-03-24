package com.example.clinical.house.digiturno.infraestructure.repositories;

import com.example.clinical.house.digiturno.infraestructure.entities.EmployeeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface EmployeeUserRepository extends JpaRepository<EmployeeUser, UUID> {
   Optional<EmployeeUser> findByUsername(String username);
}
