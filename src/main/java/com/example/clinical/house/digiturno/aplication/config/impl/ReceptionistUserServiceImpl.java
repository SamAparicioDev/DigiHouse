package com.example.clinical.house.digiturno.aplication.config.impl;

import com.example.clinical.house.digiturno.aplication.config.exceptions.generalUser.ReceptionistUserNotFoundException;
import com.example.clinical.house.digiturno.aplication.dtos.ReceptionistUserDTO;
import com.example.clinical.house.digiturno.domain.services.ReceptionistUserService;
import com.example.clinical.house.digiturno.infraestructure.entities.ReceptionistUser;
import com.example.clinical.house.digiturno.infraestructure.repositories.ReceptionistUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ReceptionistUserServiceImpl implements ReceptionistUserService {

    @Autowired
    private ReceptionistUserRepository receptionistUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public List<ReceptionistUser> listAllReceptionistUser() {
        return receptionistUserRepository.findAll();
    }

    @Override
    public ReceptionistUser getReceptionistUserById(UUID id) {
        return receptionistUserRepository.findById(id).orElseThrow(()-> new ReceptionistUserNotFoundException("Receptionist Not Found"));
    }

    @Override
    public ReceptionistUser createReceptionistUser(ReceptionistUserDTO receptionistUserDTO) {
        return receptionistUserRepository.save(new ReceptionistUser(receptionistUserDTO.username(), passwordEncoder.encode(receptionistUserDTO.password()),receptionistUserDTO.name(),receptionistUserDTO.lastName()));
    }

    @Override
    public ReceptionistUser updateReceptionistUser(UUID id, ReceptionistUserDTO receptionistUserDTO) {
        return null;
    }

    @Override
    public void deleteReceptionistUser(UUID id) {

    }
}
