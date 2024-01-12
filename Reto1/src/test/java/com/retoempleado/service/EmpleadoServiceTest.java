package com.retoempleado.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.retoempleado.model.Empleado;
import com.retoempleado.repository.EmpleadoRepository;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class EmpleadoServiceTest {

    @Mock
    private EmpleadoRepository empleadoRepository;

    @InjectMocks
    private EmpleadoServiceImpl empleadoServiceImpl;

    @Test
    public void buscarPorNombre() {

        String nombre = "Juan";
        List<Empleado> empleadosMock = Arrays.asList(new Empleado(), new Empleado());

        when(empleadoRepository.findByNombre(nombre)).thenReturn(empleadosMock);

        List<Empleado> result = empleadoServiceImpl.buscarPorNombre(nombre);

        assertEquals(empleadosMock, result);
        verify(empleadoRepository, times(1)).findByNombre(nombre);
    }

    @Test
    public void buscarPorCargo() {

        String cargo = "Desarrollador";
        List<Empleado> empleadosMock = Arrays.asList(new Empleado(), new Empleado());

        when(empleadoRepository.findByCargo(cargo)).thenReturn(empleadosMock);

        List<Empleado> result = empleadoServiceImpl.buscarPorCargo(cargo);

        assertEquals(empleadosMock, result);
        verify(empleadoRepository, times(1)).findByCargo(cargo);
    }

    @Test
    public void buscarPorDepartamento() {

        String departamento = "TI";
        List<Empleado> empleadosMock = Arrays.asList(new Empleado(), new Empleado());

        when(empleadoRepository.findByDepartamento(departamento)).thenReturn(empleadosMock);

        List<Empleado> result = empleadoServiceImpl.buscarPorDepartamento(departamento);

        assertEquals(empleadosMock, result);
        verify(empleadoRepository, times(1)).findByDepartamento(departamento);
    }
}
