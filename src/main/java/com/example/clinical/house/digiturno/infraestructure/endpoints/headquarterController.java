package com.example.clinical.house.digiturno.infraestructure.endpoints;

import com.example.clinical.house.digiturno.aplication.dtos.HeadquarterDTO;
import com.example.clinical.house.digiturno.domain.services.HeadquarterService;
import com.example.clinical.house.digiturno.infraestructure.entities.Headquarter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/headquarter")
public class headquarterController {

    @Autowired
    private HeadquarterService headquarterService;

    @GetMapping("/get")
    public ResponseEntity<List<Headquarter>> getAllHeadquarter() {
        return new ResponseEntity<>(headquarterService.listAllHeadquarter(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Headquarter> createHeadquarter(@RequestBody HeadquarterDTO headquarterDTO) {
        return new ResponseEntity<>(headquarterService.createHeadquarter(headquarterDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Headquarter> updateHeadquarter(@PathVariable UUID id, @RequestBody Headquarter headquarter) {
        return new ResponseEntity<>(headquarterService.updateHeadquarter(id, headquarter), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteHeadquarter(@PathVariable UUID id) {
        headquarterService.deleteHeadquarter(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
