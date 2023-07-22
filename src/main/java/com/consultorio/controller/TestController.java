package com.consultorio.controller;

import com.consultorio.model.Doctor;
import com.consultorio.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    private final DoctorRepository doctorRepository;

    @Autowired
    public TestController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping
    public Doctor testConnection() {
        // Realizamos una consulta a la base de datos para obtener un doctor por su ID (cambiar el 1 por un ID existente)
        Long doctorId = 1L;
        return doctorRepository.findById(doctorId).orElse(null);
    }
}

