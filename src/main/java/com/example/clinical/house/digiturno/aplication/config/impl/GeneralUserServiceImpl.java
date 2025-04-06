package com.example.clinical.house.digiturno.aplication.config.impl;

import com.example.clinical.house.digiturno.aplication.config.exceptions.generalUser.GeneralUserNotFoundException;
import com.example.clinical.house.digiturno.aplication.dtos.GeneralUserDTO;
import com.example.clinical.house.digiturno.aplication.dtos.UserState;
import com.example.clinical.house.digiturno.domain.services.GeneralUserService;
import com.example.clinical.house.digiturno.infraestructure.entities.ConsultingRoom;
import com.example.clinical.house.digiturno.infraestructure.entities.GeneralUser;
import com.example.clinical.house.digiturno.infraestructure.entities.Headquarter;
import com.example.clinical.house.digiturno.infraestructure.entities.Module;
import com.example.clinical.house.digiturno.infraestructure.repositories.*;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class GeneralUserServiceImpl implements GeneralUserService {
    @Autowired
    private GeneralUserRepository generalUserRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private RolUserRepository rolUserRepository;

    @Autowired
    private ConsultingRoomRepository consultingRoomRepository;

    @Autowired
    private EmployeeUserRepository employeeUserRepository;

    @Autowired
    private HeadquarterRepository headquarterRepository;

    @Override
    public List<GeneralUser> listAllGeneralUsers() {
        return generalUserRepository.findAll();
    }

    @Override
    public GeneralUser getGeneralUserById(UUID id) {
        return generalUserRepository.findById(id).orElseThrow(() -> new GeneralUserNotFoundException("User Not Found"));
    }

    @Override
    public GeneralUser createGeneralUser(GeneralUserDTO generalUser) {
        Module module = null;
        if (generalUser.moduleId() != null)
            module = moduleRepository.findById(generalUser.moduleId())
                    .orElseThrow(() -> new RuntimeException("Module not found"));

        ConsultingRoom consultingRoom = null;
        if (generalUser.consultingRoomId() != null)
            consultingRoom = consultingRoomRepository.findById(generalUser.consultingRoomId())
                    .orElseThrow(() -> new RuntimeException("Consulting room not found"));

        Headquarter headquarter = null;
        if (generalUser.headquarterId() != null)
            headquarter = headquarterRepository.findById(generalUser.headquarterId())
                    .orElseThrow(() -> new RuntimeException("Headquarter not found"));

        GeneralUser user = new GeneralUser(
                generalUser.nit(),
                generalUser.name(),
                generalUser.lastName(),
                module,
                consultingRoom
        );
        user.setUserState(generalUser.userState());
        user.setHeadquarter(headquarter);

        return generalUserRepository.save(user);
    }


    @Override
    public GeneralUser updateGeneralUserState(UUID id, UserState userState) {
        GeneralUser generalUserFound = generalUserRepository.getReferenceById(id);
        generalUserFound.setUserState(userState);
        return generalUserRepository.save(generalUserFound);
    }

    @Override
    public void deleteGeneralUser(UUID id) {
        generalUserRepository.deleteById(id);
    }

    @Override
    public List<GeneralUser> getUsersWithModuleOnly() {
        return generalUserRepository.findAllWithModuleAndNoConsultingRoom();
    }

    @Override
    public List<GeneralUser> getUsersByHeadquarterAndModule(UUID headquarterId, UUID moduleId) {
        return generalUserRepository.findByHeadquarterIdAndModuleId(headquarterId, moduleId);
    }

    @Override
    public List<GeneralUser> findByConsultingRoomAndHeadquarter(UUID consultingRoomId, UUID headquarterId) {
        return generalUserRepository.findByConsultingRoom_ConsultingRoomIdAndHeadquarter_Id(consultingRoomId, headquarterId);
    }

    @Override
    public List<GeneralUser> getUsersWithModuleOnlyBySede(UUID headquarterId) {
        return generalUserRepository.findByModuleOnlyAndHeadquarterId(headquarterId);
    }


}
