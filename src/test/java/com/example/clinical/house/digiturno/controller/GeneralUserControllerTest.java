package com.example.clinical.house.digiturno.controller;

import com.example.clinical.house.digiturno.aplication.dtos.GeneralUserDTO;
import com.example.clinical.house.digiturno.aplication.dtos.UserState;
import com.example.clinical.house.digiturno.domain.services.GeneralUserService;
import com.example.clinical.house.digiturno.infraestructure.endpoints.GeneralUserController;
import com.example.clinical.house.digiturno.infraestructure.entities.GeneralUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = GeneralUserController.class)
@Import(GeneralUserController.class)
class GeneralUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GeneralUserService generalUserService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllUsers() throws Exception {
        GeneralUser user = new GeneralUser();
        when(generalUserService.listAllGeneralUsers()).thenReturn(Collections.singletonList(user));

        mockMvc.perform(get("/api/user/get"))
                .andExpect(status().isOk());
    }

    @Test
    void testCreateUser() throws Exception {
        GeneralUserDTO dto = new GeneralUserDTO(
                123456L,
                "Juan",
                "Pérez",
                UserState.ESPERA, // O el enum que uses
                UUID.randomUUID(),
                UUID.randomUUID()
        );

        GeneralUser user = new GeneralUser();
        when(generalUserService.createGeneralUser(Mockito.any())).thenReturn(user);

        mockMvc.perform(post("/api/user/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated());
    }

    @Test
    void testDeleteUser() throws Exception {
        UUID userId = UUID.randomUUID();

        mockMvc.perform(delete("/api/user/delete/" + userId))
                .andExpect(status().isOk());
    }
}
