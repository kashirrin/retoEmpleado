package com.retoempleado.repository;
import com.retoempleado.model.Empleado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// La anotación @Repository indica que esta interfaz es un componente de repositorio de Spring y se encargará de interactuar con la capa de persistencia.
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    // Métodos de consulta personalizados para buscar empleados por nombre, cargo y departamento
    List<Empleado> findByNombre(String nombre);
    List<Empleado> findByCargo(String cargo);
    List<Empleado> findByDepartamento(String departamento);
    
}