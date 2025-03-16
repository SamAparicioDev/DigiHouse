package com.example.clinical.house.digiturno.infraestructure.endpoints;

import com.example.clinical.house.digiturno.aplication.dtos.GeneralUserDTO;
import com.example.clinical.house.digiturno.aplication.dtos.UserState;
import com.example.clinical.house.digiturno.domain.services.GeneralUserService;
import com.example.clinical.house.digiturno.infraestructure.entities.GeneralUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class GeneralUserController {
    @Autowired
    private GeneralUserService generalUserService;

    @PostMapping("/save")
    public ResponseEntity<GeneralUser> createUser(@RequestBody GeneralUserDTO generalUser) {
        return new ResponseEntity<>(generalUserService.createGeneralUser(generalUser), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<GeneralUser>> getAllUsers() {
        return new ResponseEntity<>(generalUserService.listAllGeneralUsers(), HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<GeneralUser> getUserById(@PathVariable UUID id){
        return new ResponseEntity<>(generalUserService.getGeneralUserById(id), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<GeneralUser> updateGeneralUserById(@PathVariable UUID id, @RequestBody UserState userState) {
        return new ResponseEntity<>(generalUserService.updateGeneralUserState(id, userState), HttpStatus.OK);
    }
    @DeleteMapping("/delete{id}")
    public ResponseEntity<GeneralUser> deleteGeneralUserById(@PathVariable UUID id) {
        generalUserService.deleteGeneralUser(id);
        return new ResponseEntity<>(generalUserService.getGeneralUserById(id), HttpStatus.OK);
    }


}
