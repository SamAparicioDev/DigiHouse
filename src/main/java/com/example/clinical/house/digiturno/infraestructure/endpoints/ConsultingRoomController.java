package com.example.clinical.house.digiturno.infraestructure.endpoints;

import com.example.clinical.house.digiturno.aplication.dtos.ConsultingRoomDTO;
import com.example.clinical.house.digiturno.domain.services.ConsultingRoomService;
import com.example.clinical.house.digiturno.infraestructure.entities.ConsultingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/consulting_room")
public class ConsultingRoomController {
    @Autowired
    private ConsultingRoomService consultingRoomService;

    @GetMapping("/get")
    public ResponseEntity<List<ConsultingRoom>> getConsultingRooms(@RequestParam UUID headquarterId) {
        return new ResponseEntity<>(consultingRoomService.getConsultingRoomsByHeadquarter(headquarterId), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ConsultingRoom> getConsultingRoomById(@PathVariable UUID id) {
        return new ResponseEntity<>(consultingRoomService.getConsultingRoomById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ConsultingRoom> updateConsultingRoomById(@PathVariable UUID id, @RequestBody ConsultingRoomDTO consultingRoom) {
        return new ResponseEntity<>(consultingRoomService.updateConsultingRoomById(id, consultingRoom), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ConsultingRoom> saveConsultingRoom(@RequestBody ConsultingRoomDTO consultingRoom) {
        return new ResponseEntity<>(consultingRoomService.saveConsultingRoom(consultingRoom), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteConsultingRoomById(@PathVariable UUID id) {
        consultingRoomService.deleteConsultingRoomById(id);
        return new ResponseEntity<>("Consulting Room has been removed", HttpStatus.OK);
    }
}
