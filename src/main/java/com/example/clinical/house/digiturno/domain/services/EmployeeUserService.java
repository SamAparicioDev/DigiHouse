package com.example.clinical.house.digiturno.domain.services;


import com.example.clinical.house.digiturno.aplication.dtos.EmployeeUserDTO;
import com.example.clinical.house.digiturno.infraestructure.entities.EmployeeUser;

import java.util.List;
import java.util.UUID;

public interface EmployeeUserService {
    List<EmployeeUser> listAllEmployeeUser();
    EmployeeUser getEmployeeUserById(UUID id);
    EmployeeUser createEmployeeUser(EmployeeUserDTO employeeUserDTO);
    EmployeeUser updateEmployeeUser(UUID id, EmployeeUserDTO employeeUserDTO);
    void deleteEmployeeUser(UUID id);
}
