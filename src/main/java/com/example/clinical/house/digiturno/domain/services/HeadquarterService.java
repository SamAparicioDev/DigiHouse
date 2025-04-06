package com.example.clinical.house.digiturno.domain.services;

import com.example.clinical.house.digiturno.aplication.dtos.HeadquarterDTO;
import com.example.clinical.house.digiturno.infraestructure.entities.Headquarter;

import java.util.List;
import java.util.UUID;

public interface HeadquarterService {
    List<Headquarter> listAllHeadquarter();

    Headquarter createHeadquarter(HeadquarterDTO headquarterDTO);

    Headquarter updateHeadquarter(UUID id, Headquarter updatedHeadquarter);

    void deleteHeadquarter(UUID id);
}

