package com.example.clinical.house.digiturno.infraestructure.endpoints;

import com.example.clinical.house.digiturno.aplication.dtos.ModuleDTO;
import com.example.clinical.house.digiturno.domain.services.ModuleService;
import com.example.clinical.house.digiturno.infraestructure.entities.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/module")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;
    @GetMapping
    public ResponseEntity<List<Module>> getAllModules(){
        return new ResponseEntity<>(moduleService.listAll(), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Module> createModule(@RequestBody ModuleDTO module){
        return new ResponseEntity<>(moduleService.saveModule(module),HttpStatus.CREATED);
    }
}
