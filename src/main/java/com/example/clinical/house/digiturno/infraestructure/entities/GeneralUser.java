package com.example.clinical.house.digiturno.infraestructure.entities;

import com.example.clinical.house.digiturno.aplication.dtos.UserState;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
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
    @Column
    @Setter
    private String lastName;
    @Setter
    @Column(nullable = false)
    @JsonSetter(nulls = Nulls.SKIP)
    private UserState userState = UserState.ESPERA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private Module module;

    public GeneralUser(Long nit, String name, String lastName, Module module) {
        this.nit = nit;
        this.name = name;
        this.lastName = lastName;
        this.module = module;
    }

}
