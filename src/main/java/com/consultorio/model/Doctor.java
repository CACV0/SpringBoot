package com.consultorio.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank; 

@Entity
@Table(name = "doctores")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El campo apellido es obligatorio")
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "especialidad_id", referencedColumnName = "id")
    private Especialidad especialidad;

    private int consultorio;

    @NotBlank(message = "El campo correo es obligatorio")
    private String correo;

    // Constructor vacío
    public Doctor() {
    }

    // Constructor con todos los atributos
    public Doctor(Long id, String nombre, String apellido, Especialidad especialidad, int consultorio, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.consultorio = consultorio;
        this.correo = correo;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public int getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(int consultorio) {
        this.consultorio = consultorio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Método toString()
    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", especialidad=" + especialidad +
                ", consultorio=" + consultorio +
                ", correo='" + correo + '\'' +
                '}';
    }
}
