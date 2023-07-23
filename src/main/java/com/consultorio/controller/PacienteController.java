package com.consultorio.controller;

import com.consultorio.model.Paciente;
import com.consultorio.service.PacienteService; // Agregar esta importación

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;
import org.springframework.validation.ObjectError;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService; // Cambiar el nombre del servicio

    @Autowired
    public PacienteController(PacienteService pacienteService) { // Cambiar el nombre del servicio
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        List<Paciente> pacientes = pacienteService.getAllPacientes(); // Cambiar el nombre del servicio
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
        Paciente paciente = pacienteService.getPacienteById(id); // Cambiar el nombre del servicio
        if (paciente != null) {
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createPaciente(@Valid @RequestBody Paciente paciente,
            BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            return ResponseEntity.badRequest().body(errors);
        }

        Paciente newPaciente = pacienteService.createPaciente(paciente); // Cambiar el nombre del servicio
        return new ResponseEntity<>(newPaciente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id,
            @RequestBody Paciente paciente) {
        Paciente existingPaciente = pacienteService.updatePaciente(id, paciente); // Cambiar el nombre del servicio
        if (existingPaciente != null) {
            return new ResponseEntity<>(existingPaciente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id); // Cambiar el nombre del servicio
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}