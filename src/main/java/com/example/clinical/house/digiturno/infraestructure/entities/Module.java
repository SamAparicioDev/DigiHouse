package com.example.clinical.house.digiturno.infraestructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "module")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Setter
    private String name;

    public Module(String name) {
        this.name = name;
    }

}
