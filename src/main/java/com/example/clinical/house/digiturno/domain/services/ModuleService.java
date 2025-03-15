package com.example.clinical.house.digiturno.domain.services;

import com.example.clinical.house.digiturno.aplication.dtos.ModuleDTO;
import com.example.clinical.house.digiturno.infraestructure.entities.Module;

import java.util.List;

public interface ModuleService {
    List<Module> listAll();
    Module saveModule(ModuleDTO module);
}
