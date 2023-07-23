package com.consultorio.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank; 

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El campo cedula es obligatorio")
    @Size(min = 10, max = 10, message = "La cedula debe tener 10 caracteres")
    private String cedula;

    @NotBlank(message = "El campo apellido es obligatorio")
    private String apellido;

    private int edad;

    @NotBlank(message = "El campo telefono es obligatorio")
    @Size(min = 10, max = 10, message = "El telefono debe tener 10 caracteres")
    private String telefono;

    // Constructor vacío
    public Paciente() {
    }

    // Constructor con todos los atributos
    public Paciente(Long id, String nombre, String cedula, String apellido, int edad, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
    }

    // Getters y Setters
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método toString()
    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
