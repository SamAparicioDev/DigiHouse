package com.example.clinical.house.digiturno.infraestructure.entities;

import com.example.clinical.house.digiturno.aplication.dtos.UserState;
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
    @Setter
    private UserState state = UserState.ESPERA;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receptionist_user_id")
    private ReceptionistUser receptionistUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private Module module;

    public GeneralUser(Long nit, String name, String lastName, UserState state, ReceptionistUser receptionistUser, Module module) {
        this.nit = nit;
        this.name = name;
        this.lastName = lastName;
        this.state = state;
        this.receptionistUser = receptionistUser;
        this.module = module;
    }

}
