package com.example.clinical.house.digiturno.infraestructure.endpoints;

import com.example.clinical.house.digiturno.aplication.dtos.RolUserDTO;
import com.example.clinical.house.digiturno.domain.services.RolUserService;
import com.example.clinical.house.digiturno.infraestructure.entities.RolUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/rol")
public class RolUserController {
    @Autowired
    private RolUserService rolUserService;


    @GetMapping("/get/{id}")
    public ResponseEntity<RolUser> getRolUserById(@PathVariable UUID id) {
        return new ResponseEntity<>(rolUserService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<RolUser>> getAllRolUsers() {
        return new ResponseEntity<>(rolUserService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RolUser> updateRolUserById(@PathVariable UUID id, @RequestBody RolUserDTO rolUser) {
        return new ResponseEntity<>(rolUserService.updateRolUserById(id, rolUser), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<RolUser> saveRolUser(@RequestBody RolUserDTO rolUser) {
        return new ResponseEntity<>(rolUserService.saveRolUser(rolUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRolUserById(@PathVariable UUID id) {
        rolUserService.deleteRolUserById(id);
        return new ResponseEntity<>("Rol has been removed", HttpStatus.OK);
    }
}
