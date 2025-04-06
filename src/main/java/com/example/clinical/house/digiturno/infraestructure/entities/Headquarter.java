package com.example.clinical.house.digiturno.infraestructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "headquarters")
public class Headquarter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "headquarter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConsultingRoom> consultingRooms = new ArrayList<>();

    @OneToMany(mappedBy = "headquarter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Module> modules = new ArrayList<>();


    public Headquarter(String name) {
        this.name = name;
    }

}