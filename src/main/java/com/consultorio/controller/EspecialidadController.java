package com.consultorio.controller;

import com.consultorio.model.Especialidad;
import com.consultorio.service.EspecialidadService; // Agregar esta importación

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;
import org.springframework.validation.ObjectError;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {

    private final EspecialidadService especialidadService; // Cambiar el nombre del servicio

    @Autowired
    public EspecialidadController(EspecialidadService especialidadService) { // Cambiar el nombre del servicio
        this.especialidadService = especialidadService;
    }

    @GetMapping
    public ResponseEntity<List<Especialidad>> getAllEspecialidades() {
        List<Especialidad> especialidades = especialidadService.getAllEspecialidades(); // Cambiar el nombre del
                                                                                        // servicio
        return new ResponseEntity<>(especialidades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> getEspecialidadById(@PathVariable Long id) {
        Especialidad especialidad = especialidadService.getEspecialidadById(id); // Cambiar el nombre del servicio
        if (especialidad != null) {
            return new ResponseEntity<>(especialidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createEspecialidad(@Valid @RequestBody Especialidad especialidad,
            BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            return ResponseEntity.badRequest().body(errors);
        }

        Especialidad newEspecialidad = especialidadService.createEspecialidad(especialidad); // Cambiar el nombre del
                                                                                             // servicio
        return new ResponseEntity<>(newEspecialidad, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> updateEspecialidad(@PathVariable Long id,
            @RequestBody Especialidad especialidad) {
        Especialidad existingEspecialidad = especialidadService.updateEspecialidad(id, especialidad); // Cambiar el
                                                                                                      // nombre del
                                                                                                      // servicio
        if (existingEspecialidad != null) {
            return new ResponseEntity<>(existingEspecialidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecialidad(@PathVariable Long id) {
        especialidadService.deleteEspecialidad(id); // Cambiar el nombre del servicio
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}