package com.example.clinical.house.digiturno.domain.mapper;


import com.example.clinical.house.digiturno.aplication.dtos.GeneralUserDTO;
import com.example.clinical.house.digiturno.infraestructure.entities.GeneralUser;

public class GeneralUserMapper {
    public static GeneralUser generalUserDtoToGeneralUser(GeneralUserDTO generalUserDTO){
        return new GeneralUser(generalUserDTO.id(), generalUserDTO.nit(), generalUserDTO.name(), generalUserDTO.lastName(),generalUserDTO.userState(), generalUserDTO.receptionistUser(),generalUserDTO.module());
    }
    public static GeneralUser generalUserDtoUpdate(GeneralUser generalUser, GeneralUserDTO generalUserDTO){
        generalUser.setName(generalUserDTO.name());
        generalUser.setLastName(generalUserDTO.lastName());
        return generalUser;
    }
}
