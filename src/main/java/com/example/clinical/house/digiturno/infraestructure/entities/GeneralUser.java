package com.example.clinical.house.digiturno.infraestructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "general_user")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GeneralUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(unique = true)
    private Long nit;
    @Column(nullable = false)
    @Setter
    private String name;
    @Column(nullable = false)
    @Setter
    private String lastName;
}
