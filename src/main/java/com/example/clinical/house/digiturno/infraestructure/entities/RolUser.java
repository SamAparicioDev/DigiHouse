package com.example.clinical.house.digiturno.infraestructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "rol_user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RolUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID rolUserId;
    @Column(unique = true, nullable = false)
    @Setter
    private String name;

    public RolUser(String name) {
        this.name = name;
    }
}
