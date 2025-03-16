package com.example.clinical.house.digiturno.infraestructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "receptionist")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReceptionistUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID receptionistUserId;
    @Column(unique = true, nullable = false)
    @Setter
    private String username;
    @Column(nullable = false)
    @Setter
    private String password;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String lastName;

    public ReceptionistUser(String username, String password, String name, String lastName) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;

    }
}
