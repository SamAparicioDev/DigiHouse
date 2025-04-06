package com.example.clinical.house.digiturno.domain.services;

import com.example.clinical.house.digiturno.aplication.dtos.GeneralUserDTO;
import com.example.clinical.house.digiturno.aplication.dtos.UserState;
import com.example.clinical.house.digiturno.infraestructure.entities.GeneralUser;
import org.apache.catalina.User;

import java.util.List;
import java.util.UUID;

public interface GeneralUserService {
    List<GeneralUser> listAllGeneralUsers();

    GeneralUser getGeneralUserById(UUID id);

    GeneralUser createGeneralUser(GeneralUserDTO generalUser);

    GeneralUser updateGeneralUserState(UUID id, UserState userState);

    void deleteGeneralUser(UUID id);

    List<GeneralUser> getUsersWithModuleOnly();

    List<GeneralUser> getUsersByHeadquarterAndModule(UUID headquarterId, UUID moduleId);

    List<GeneralUser> findByConsultingRoomAndHeadquarter(UUID consultingRoomId, UUID headquarterId);

    List<GeneralUser> getUsersWithModuleOnlyBySede(UUID headquarterId);
}
