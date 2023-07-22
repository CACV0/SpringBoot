package com.consultorio.controller;

import com.consultorio.model.Especialidad;
import com.consultorio.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {

    private final EspecialidadRepository especialidadRepository;

    @Autowired
    public EspecialidadController(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @GetMapping
    public ResponseEntity<List<Especialidad>> getAllEspecialidades() {
        List<Especialidad> especialidades = especialidadRepository.findAll();
        return new ResponseEntity<>(especialidades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> getEspecialidadById(@PathVariable Long id) {
        Especialidad especialidad = especialidadRepository.findById(id).orElse(null);
        if (especialidad != null) {
            return new ResponseEntity<>(especialidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Especialidad> createEspecialidad(@RequestBody Especialidad especialidad) {
        Especialidad newEspecialidad = especialidadRepository.save(especialidad);
        return new ResponseEntity<>(newEspecialidad, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> updateEspecialidad(@PathVariable Long id, @RequestBody Especialidad especialidad) {
        Especialidad existingEspecialidad = especialidadRepository.findById(id).orElse(null);
        if (existingEspecialidad != null) {
            existingEspecialidad.setNombre(especialidad.getNombre());

            especialidadRepository.save(existingEspecialidad);
            return new ResponseEntity<>(existingEspecialidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecialidad(@PathVariable Long id) {
        Especialidad especialidad = especialidadRepository.findById(id).orElse(null);
        if (especialidad != null) {
            especialidadRepository.delete(especialidad);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
