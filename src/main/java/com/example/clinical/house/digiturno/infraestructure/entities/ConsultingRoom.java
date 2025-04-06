package com.example.clinical.house.digiturno.infraestructure.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "consulting_room")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ConsultingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID consultingRoomId;
    @Setter
    @Column(nullable = false)
    private String name;

    @Setter
    @ManyToOne
    @JoinColumn(name = "headquarter_id")
    @JsonIgnore
    private Headquarter headquarter;


    public ConsultingRoom(String name, Headquarter headquarter) {
        this.name = name;
        this.headquarter = headquarter;
    }
}
