package com.example.clinical.house.digiturno.aplication.config.impl;

import com.example.clinical.house.digiturno.aplication.config.exceptions.generalUser.EmployeeUserNotFoundException;
import com.example.clinical.house.digiturno.aplication.dtos.EmployeeUserDTO;
import com.example.clinical.house.digiturno.domain.services.EmployeeUserService;
import com.example.clinical.house.digiturno.infraestructure.entities.EmployeeUser;
import com.example.clinical.house.digiturno.infraestructure.entities.Headquarter;
import com.example.clinical.house.digiturno.infraestructure.entities.RolUser;
import com.example.clinical.house.digiturno.infraestructure.repositories.EmployeeUserRepository;
import com.example.clinical.house.digiturno.infraestructure.repositories.HeadquarterRepository;
import com.example.clinical.house.digiturno.infraestructure.repositories.RolUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeUserServiceImpl implements EmployeeUserService {

    @Autowired
    private EmployeeUserRepository employeeUserRepository;

    @Autowired
    private RolUserRepository rolUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HeadquarterRepository headquarterRepository;

    @Override
    public List<EmployeeUser> listAllEmployeeUser() {
        return employeeUserRepository.findAll();
    }

    @Override
    public EmployeeUser getEmployeeUserById(UUID id) {
        return employeeUserRepository.findById(id).orElseThrow(() -> new EmployeeUserNotFoundException("Employee Not Found"));
    }

    @Override
    public EmployeeUser createEmployeeUser(EmployeeUserDTO employeeUserDTO) {
        RolUser rolUser = rolUserRepository.findById(employeeUserDTO.rolUserId()).orElseThrow(() -> new EmployeeUserNotFoundException("Rol User Not Found"));
        Headquarter headquarter = null;
        if (employeeUserDTO.headquarterId() != null) {
            headquarter = headquarterRepository.findById(employeeUserDTO.headquarterId())
                    .orElseThrow(() -> new EmployeeUserNotFoundException("Headquarter Not Found"));
        }

        return employeeUserRepository.save(new EmployeeUser(employeeUserDTO.username(), passwordEncoder.encode(employeeUserDTO.password()), employeeUserDTO.name(), employeeUserDTO.lastName(), employeeUserDTO.email(), rolUser, headquarter));
    }

    @Override
    public EmployeeUser updateEmployeeUser(UUID id, EmployeeUserDTO employeeUserDTO) {
        return null;
    }

    @Override
    public void deleteEmployeeUser(UUID id) {

    }
}
