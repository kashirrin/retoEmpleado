package com.retoempleado.service;

import com.retoempleado.model.Empleado;
import com.retoempleado.repository.EmpleadoRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {

    // Repositorio y JdbcTemplate inyectados por el constructor
    private final EmpleadoRepository empleadoRepository;
    private final JdbcTemplate jdbcTemplate;
    
    // Constructor que recibe los repositorios y el JdbcTemplate como parámetros
    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository, JdbcTemplate jdbcTemplate) {
        this.empleadoRepository = empleadoRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    // Método para crear un nuevo empleado
    @Override
    @PreAuthorize("hasRole('ADMIN')")
    // SQL para insertar un nuevo empleado en la base de datos
    public Empleado crearEmpleado(Empleado empleado) {
        String sql = "INSERT INTO empleado (id, nombre, cargo, departamento, fecha_ingreso, salario, correo_electronico) " +
                    "VALUES (empleado_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";
        
        // Ejecuta la actualización de la base de datos con los valores del nuevo empleado
        jdbcTemplate.update(sql, 
            empleado.getNombre(), 
            empleado.getCargo(), 
            empleado.getDepartamento(),
            empleado.getFechaIngreso(),
            empleado.getSalario(),
            empleado.getCorreoElectronico()
        );

        // Obtiene el ID generado automáticamente
        Long idGenerado = jdbcTemplate.queryForObject("SELECT empleado_seq.CURRVAL FROM dual", Long.class);
        
        // Actualiza el objeto Empleado con el ID creado
        empleado.setId(idGenerado);

        return empleado;
    }

    // Método para obtener todos los empleados
    @Override
    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoRepository.findAll();
    }

    // Método para obtener un empleado por su ID
    @Override
    public Optional<Empleado> obtenerEmpleadoPorId(Long id) {
        return empleadoRepository.findById(id);
    }

    // Método para actualizar un empleado por su ID
    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Empleado actualizarEmpleado(Empleado empleado) {
        String sql = "BEGIN actualizar_empleado(?, ?, ?, ?, ?, ?, ?); END;";
        jdbcTemplate.update(sql, 
            empleado.getId(),
            empleado.getNombre(), 
            empleado.getCargo(), 
            empleado.getDepartamento(),
            empleado.getFechaIngreso(),
            empleado.getSalario(),
            empleado.getCorreoElectronico()
        );
        return empleado;
    }

    // Método para eliminar un empleado por su ID
    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminarEmpleado(Long id) {
        String sql = "BEGIN eliminar_empleado(?); END;";
        jdbcTemplate.update(sql, id);
    }

    // Métodos para buscar empleados por nombre, cargo y departamento
    @Override
    public List<Empleado> buscarPorNombre(String nombre) {

        return empleadoRepository.findByNombre(nombre);
    }

    @Override
    public List<Empleado> buscarPorCargo(String cargo) {

        return empleadoRepository.findByCargo(cargo);
    }

    @Override
    public List<Empleado> buscarPorDepartamento(String departamento) {

        return empleadoRepository.findByDepartamento(departamento);
    }
}