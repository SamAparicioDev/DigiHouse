package com.example.clinical.house.digiturno.infraestructure.entities;

import jakarta.persistence.*;

@Table(name = "module")
@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
}
