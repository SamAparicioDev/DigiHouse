package com.example.clinical.house.digiturno.domain.services;

import com.example.clinical.house.digiturno.aplication.dtos.LoginRequest;
import org.springframework.stereotype.Service;


public interface LoginService {
    String authenticateUser(LoginRequest loginRequest);
}
