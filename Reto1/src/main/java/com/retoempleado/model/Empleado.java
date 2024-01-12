package com.retoempleado.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import java.util.Date;

@Entity
public class Empleado {

    // Identificador único generado automáticamente por la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;

    @Column(name = "salario")
    private double salario;

    @Column(name = "correo_electronico", unique = true)
    private String correoElectronico;

    public Empleado() {
    }

    // Constructor con todos los campos
    public Empleado(String nombre, String cargo, String departamento, Date fechaIngreso, double salario, String correoElectronico) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.departamento = departamento;
        this.fechaIngreso = fechaIngreso;
        this.salario = salario;
        this.correoElectronico = correoElectronico;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}