package com.example.clinical.house.digiturno.aplication.dtos;

import com.example.clinical.house.digiturno.infraestructure.entities.RolUser;

public record EmployeeUserDTO(String username, String password, String name, String lastName, RolUser rolUser) {
}
