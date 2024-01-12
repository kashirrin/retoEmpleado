package com.retoempleado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    // Método principal que inicia la aplicación Spring Boot
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // Método para configurar la aplicación cuando se despliega en un contenedor Servlet externo
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // Configuración adicional, como el puerto del servidor, al desplegar en un entorno externo
        return application.sources(Application.class).properties("server.port=8080");
    }
}
