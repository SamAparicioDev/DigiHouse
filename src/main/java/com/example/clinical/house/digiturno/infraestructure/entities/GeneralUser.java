package com.example.clinical.house.digiturno.infraestructure.entities;

import com.example.clinical.house.digiturno.aplication.dtos.UserState;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.annotation.Nullable;
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


    @ManyToOne
    @JoinColumn(name = "module_id", nullable = true)
    @Setter
    private Module module;


    @ManyToOne
    @JoinColumn(name = "consulting_room_id", nullable = true)
    @Setter
    private ConsultingRoom consultingRoom;

    public GeneralUser(Long nit, String name, String lastName, Module module, ConsultingRoom consultingRoom) {
        this.nit = nit;
        this.name = name;
        this.lastName = lastName;
        this.module = module;
        this.consultingRoom = consultingRoom;
    }

    public GeneralUser(Long nit, String name, String lastName) {
        this.nit = nit;
        this.name = name;
        this.lastName = lastName;
    }

}
