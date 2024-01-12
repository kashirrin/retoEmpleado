package com.retoempleado.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Implementación del método de la interfaz UserDetailsService
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Crear y devolver un objeto UserDetails con un nombre de usuario, contraseña en texto plano, y un rol "ADMIN"
        return User.withUsername(username)
            .password("password")
            .roles("ADMIN")
            .build();
    }
}
