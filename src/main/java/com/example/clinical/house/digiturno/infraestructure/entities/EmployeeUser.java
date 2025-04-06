package com.example.clinical.house.digiturno.infraestructure.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "employee")
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

    @Column(nullable = false)
    @Setter
    private String name;

    @Column(nullable = false)
    @Setter
    private String lastName;

    @Column(unique = true, nullable = false)
    @Setter
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_user_id")
    @Setter
    private RolUser rolUser;

    @ManyToOne
    @JoinColumn(name = "headquarter_id", nullable = true)
    @Setter
    private Headquarter headquarter;

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = true)
    @Setter
    private Module module;

    @ManyToOne
    @JoinColumn(name = "consulting_room_id", nullable = true)
    @Setter
    private ConsultingRoom consultingRoom;

    public EmployeeUser(String username, String password, String name, String lastName, String email, RolUser rolUser, Headquarter headquarter) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.rolUser = rolUser;
        this.headquarter = headquarter;
    }
}
