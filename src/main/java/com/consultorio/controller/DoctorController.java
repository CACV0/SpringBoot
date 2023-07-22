package com.consultorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.consultorio.model.Doctor;
import com.consultorio.repository.DoctorRepository;

import java.util.List;

@RestController
@RequestMapping("/doctores")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    public List<Doctor> obtenerTodosLosDoctores() {
        return doctorRepository.findAll();
    }

    @PostMapping
    public Doctor agregarDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @PutMapping("/{id}")
    public Doctor actualizarDoctor(@PathVariable Long id, @RequestBody Doctor doctorActualizado) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Doctor no encontrado con ID: " + id));

        doctor.setNombre(doctorActualizado.getNombre());
        doctor.setApellido(doctorActualizado.getApellido());
        doctor.setEspecialidad(doctorActualizado.getEspecialidad());
        return doctorRepository.save(doctor);
    }

    @DeleteMapping("/{id}")
    public void eliminarDoctor(@PathVariable Long id) {
        doctorRepository.deleteById(id);
    }
}
