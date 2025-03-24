package com.example.clinical.house.digiturno.infraestructure.endpoints;

import com.example.clinical.house.digiturno.aplication.dtos.EmployeeUserDTO;
import com.example.clinical.house.digiturno.domain.services.EmployeeUserService;
import com.example.clinical.house.digiturno.infraestructure.entities.EmployeeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeUserController {

    @Autowired
    private EmployeeUserService employeeUserService;

    @PostMapping("/save")
    public ResponseEntity<EmployeeUser> createEmployeeUser(@RequestBody EmployeeUserDTO employeeUserDTO) {
        return new ResponseEntity<>(employeeUserService.createEmployeeUser(employeeUserDTO), HttpStatus.CREATED);
    }
}
