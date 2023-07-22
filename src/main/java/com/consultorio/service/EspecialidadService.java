package com.consultorio.service;

import com.consultorio.model.Especialidad;
import com.consultorio.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadService {

    private final EspecialidadRepository especialidadRepository;

    @Autowired
    public EspecialidadService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public List<Especialidad> getAllEspecialidades() {
        return especialidadRepository.findAll();
    }

    public Especialidad getEspecialidadById(Long id) {
        return especialidadRepository.findById(id).orElse(null);
    }

    public Especialidad createEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    public Especialidad updateEspecialidad(Long id, Especialidad especialidad) {
        Especialidad existingEspecialidad = especialidadRepository.findById(id).orElse(null);
        if (existingEspecialidad != null) {
            existingEspecialidad.setNombre(especialidad.getNombre());
            return especialidadRepository.save(existingEspecialidad);
        } else {
            return null;
        }
    }

    public void deleteEspecialidad(Long id) {
        Especialidad especialidad = especialidadRepository.findById(id).orElse(null);
        if (especialidad != null) {
            especialidadRepository.delete(especialidad);
        }
    }
}

