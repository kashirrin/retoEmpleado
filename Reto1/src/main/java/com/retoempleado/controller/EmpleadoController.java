package com.retoempleado.controller;

import com.retoempleado.model.Empleado;
import com.retoempleado.service.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    // Servicio de Empleado inyectado por el constructor
    private final EmpleadoService empleadoService;

    // Constructor que recibe el servicio de Empleado como parámetro
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    // Endpoint para crear un nuevo empleado
    @PostMapping
    public Empleado crearEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.crearEmpleado(empleado);
    }

    // Endpoint para obtener todos los empleados
    @GetMapping
    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoService.obtenerTodosLosEmpleados();
    }

    // Endpoint para obtener un empleado por su ID
    @GetMapping("/{id}")
    public Empleado obtenerEmpleadoPorId(@PathVariable Long id) {
        return empleadoService.obtenerEmpleadoPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado con ID: " + id));
    }

    // Endpoint para actualizar un empleado por su ID
    @PutMapping("/{id}")
    public Empleado actualizarEmpleadoPorId(@PathVariable Long id, @RequestBody Empleado empleado) {
        empleado.setId(id);
        return empleadoService.actualizarEmpleado(empleado);
    }

    // Endpoint para eliminar un empleado por su ID
    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@PathVariable Long id) {
        empleadoService.eliminarEmpleado(id);
    }

    // Endpoint para buscar empleados por nombre
    @GetMapping("/buscarPorNombre")
    public ResponseEntity<List<Empleado>> buscarPorNombre(@RequestParam String nombre) {
        List<Empleado> empleados = empleadoService.buscarPorNombre(nombre);
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    // Endpoint para buscar empleados por cargo
    @GetMapping("/buscarPorCargo")
    public ResponseEntity<List<Empleado>> buscarPorCargo(@RequestParam String cargo) {
        List<Empleado> empleados = empleadoService.buscarPorCargo(cargo);
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    // Endpoint para buscar empleados por departamento
    @GetMapping("/buscarPorDepartamento")
    public ResponseEntity<List<Empleado>> buscarPorDepartamento(@RequestParam String departamento) {
        List<Empleado> empleados = empleadoService.buscarPorDepartamento(departamento);
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }
}
