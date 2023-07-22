package com.consultorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.consultorio.model.Especialidad;
import com.consultorio.repository.EspecialidadRepository;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @GetMapping
    public List<Especialidad> obtenerTodasLasEspecialidades() {
        return especialidadRepository.findAll();
    }

    @PostMapping
    public Especialidad agregarEspecialidad(@RequestBody Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @PutMapping("/{id}")
    public Especialidad actualizarEspecialidad(@PathVariable Long id, @RequestBody Especialidad especialidadActualizada) {
        Especialidad especialidad = especialidadRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Especialidad no encontrada con ID: " + id));

        especialidad.setNombre(especialidadActualizada.getNombre());
        return especialidadRepository.save(especialidad);
    }

    @DeleteMapping("/{id}")
    public void eliminarEspecialidad(@PathVariable Long id) {
        especialidadRepository.deleteById(id);
    }
}
