package com.retoempleado.service;
import java.util.List;
import java.util.Optional;
import com.retoempleado.model.Empleado;

public interface EmpleadoService {
    // Métodos para realizar operaciones CRUD en la entidad Empleado
    Empleado crearEmpleado(Empleado empleado);
    List<Empleado> obtenerTodosLosEmpleados();
    Optional<Empleado> obtenerEmpleadoPorId(Long id);
    Empleado actualizarEmpleado(Empleado empleado);
    void eliminarEmpleado(Long id);

    // Métodos de búsqueda personalizados
    List<Empleado> buscarPorNombre(String nombre);
    List<Empleado> buscarPorCargo(String cargo);
    List<Empleado> buscarPorDepartamento(String departamento);

}
