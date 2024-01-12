package com.retoempleado.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {

    // Configuración de la fuente de datos (DataSource)
    private final DataSource dataSource;

    // Recibe la fuente de datos como parámetro
    public DataBaseConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Configura el objeto JdbcTemplate como un bean de Spring
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }
}
