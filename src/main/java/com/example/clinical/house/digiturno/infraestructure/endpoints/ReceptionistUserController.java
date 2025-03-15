package com.example.clinical.house.digiturno.infraestructure.endpoints;

import com.example.clinical.house.digiturno.aplication.dtos.ReceptionistUserDTO;
import com.example.clinical.house.digiturno.domain.services.ReceptionistUserService;
import com.example.clinical.house.digiturno.infraestructure.entities.ReceptionistUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/receptionist")
public class ReceptionistUserController {

    @Autowired
    private ReceptionistUserService receptionistUserService;

    @PostMapping
    public ResponseEntity<ReceptionistUser> createReceptionistUser(@RequestBody ReceptionistUserDTO receptionistUser) {
        return new ResponseEntity<>(receptionistUserService.createReceptionistUser(receptionistUser), HttpStatus.CREATED);
    }
}
