package com.example.clinical.house.digiturno.aplication.dtos;

import com.example.clinical.house.digiturno.infraestructure.entities.RolUser;

import java.util.UUID;

public record EmployeeUserDTO(String username, String password, String name, String lastName, String email,
                              UUID rolUserId, UUID headquarterId) {
}
