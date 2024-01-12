package com.retoempleado.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTest {

    @Test
    public void testCrearEmpleado() {
        Empleado empleado = new Empleado("Juan", "Almacén", null, null, 0, null);

        assertEquals("Juan", empleado.getNombre());
        assertEquals("Almacén", empleado.getCargo());
    }
}