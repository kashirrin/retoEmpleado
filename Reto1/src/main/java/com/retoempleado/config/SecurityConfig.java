package com.retoempleado.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Configuración de la seguridad web mediante la extensión de WebSecurityConfigurerAdapter
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // Configuración de la autorización de las solicitudes HTTP
            .authorizeRequests()
                .antMatchers("/public/**").permitAll() // Permitir acceso sin autenticación a rutas que comiencen con "/public/"
                .anyRequest().authenticated() // Todas las demás solicitudes requieren autenticación
                .and()
            // Configuración del formulario de inicio de sesión
            .formLogin()
                .loginPage("/login") // Ruta para la página de inicio de sesión
                .permitAll() // Permite acceso sin autenticación a la página de inicio de sesión
                .and()
            // Configuración de la funcionalidad de cierre de sesión
            .logout()
                .permitAll(); // Permite acceso sin autenticación a la funcionalidad de cierre de sesión
    }
}
