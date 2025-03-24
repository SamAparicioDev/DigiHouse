package com.example.clinical.house.digiturno.infraestructure.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Employee")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID employeeUserId;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_user_id")
    private RolUser rolUser;

    public EmployeeUser(String username, String password, String name, String lastName, RolUser rolUser) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.rolUser = rolUser;

    }
}
