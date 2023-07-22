package com.consultorio.controller;

import com.consultorio.model.Cita;
import com.consultorio.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitasController {

    private final CitaRepository citaRepository;

    @Autowired
    public CitasController(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Cita>> getAllCitas() {
        List<Cita> citas = citaRepository.findAll();
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> getCitaById(@PathVariable Long id) {
        Cita cita = citaRepository.findById(id).orElse(null);
        if (cita != null) {
            return new ResponseEntity<>(cita, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Cita> createCita(@RequestBody Cita cita) {
        Cita newCita = citaRepository.save(cita);
        return new ResponseEntity<>(newCita, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> updateCita(@PathVariable Long id, @RequestBody Cita cita) {
        Cita existingCita = citaRepository.findById(id).orElse(null);
        if (existingCita != null) {
            existingCita.setPaciente(cita.getPaciente());
            existingCita.setDoctor(cita.getDoctor());
            existingCita.setEspecialidad(cita.getEspecialidad());
            existingCita.setFecha(cita.getFecha());
            existingCita.setHora(cita.getHora());

            citaRepository.save(existingCita);
            return new ResponseEntity<>(existingCita, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCita(@PathVariable Long id) {
        Cita cita = citaRepository.findById(id).orElse(null);
        if (cita != null) {
            citaRepository.delete(cita);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
