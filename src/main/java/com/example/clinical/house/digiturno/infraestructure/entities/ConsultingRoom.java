package com.example.clinical.house.digiturno.infraestructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "consulting_room")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ConsultingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Setter
    @Column(unique = true, nullable = false)
    private String name;

    public ConsultingRoom(String name) {
        this.name = name;
    }
}
