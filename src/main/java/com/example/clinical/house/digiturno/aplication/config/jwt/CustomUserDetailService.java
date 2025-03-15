package com.example.clinical.house.digiturno.aplication.config.jwt;

import com.example.clinical.house.digiturno.infraestructure.entities.ReceptionistUser;
import com.example.clinical.house.digiturno.infraestructure.repositories.ReceptionistUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private ReceptionistUserRepository receptionisUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ReceptionistUser receptionistUser = receptionisUserRepository.findByUsername(username).orElseThrow(null);
        return new User(receptionistUser.getUsername(), receptionistUser.getPassword(), AuthorityUtils.NO_AUTHORITIES);

    }
}
