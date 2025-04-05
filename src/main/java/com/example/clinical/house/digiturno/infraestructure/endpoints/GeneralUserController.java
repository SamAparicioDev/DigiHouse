package com.example.clinical.house.digiturno.infraestructure.endpoints;

import com.example.clinical.house.digiturno.aplication.dtos.GeneralUserDTO;
import com.example.clinical.house.digiturno.aplication.dtos.UserState;
import com.example.clinical.house.digiturno.domain.services.GeneralUserService;
import com.example.clinical.house.digiturno.infraestructure.entities.GeneralUser;
import org.apache.catalina.User;
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

    @GetMapping("/get/consultory")
    public ResponseEntity<List<GeneralUser>> getUsers(@RequestParam(required = false) UUID consultingRoomId) {
        if (consultingRoomId != null) {
            return new ResponseEntity<>(generalUserService.findByConsultingRoomId(consultingRoomId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(generalUserService.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping("/get/module")
    public ResponseEntity<List<GeneralUser>> getUsersByModule(@RequestParam(required = false) UUID moduleId) {
        if (moduleId != null) {
            return ResponseEntity.ok(generalUserService.getUsersByModuleId(moduleId));
        } else {
            return ResponseEntity.ok(generalUserService.findAll());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<GeneralUser> getUserById(@PathVariable UUID id) {
        return new ResponseEntity<>(generalUserService.getGeneralUserById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GeneralUser> updateGeneralUserById(@PathVariable UUID id, @RequestBody UserState userState) {
        return new ResponseEntity<>(generalUserService.updateGeneralUserState(id, userState), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGeneralUserById(@PathVariable UUID id) {
        generalUserService.deleteGeneralUser(id);
        return new ResponseEntity<>("User has been removed", HttpStatus.OK);
    }

    @GetMapping("/get/tv")
    public ResponseEntity<List<GeneralUser>> getUsersForTV() {
        return new ResponseEntity<>(generalUserService.getUsersWithModuleOnly(), HttpStatus.OK);
    }

}
