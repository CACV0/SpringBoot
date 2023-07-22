package com.consultorio.service;

import com.consultorio.model.Cita;
import com.consultorio.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitasService {

    private final CitaRepository citaRepository;

    @Autowired
    public CitasService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    public Cita getCitaById(Long id) {
        return citaRepository.findById(id).orElse(null);
    }

    public Cita createCita(Cita cita) {
        return citaRepository.save(cita);
    }

    public Cita updateCita(Long id, Cita cita) {
        Cita existingCita = citaRepository.findById(id).orElse(null);
        if (existingCita != null) {
            existingCita.setPaciente(cita.getPaciente());
            existingCita.setDoctor(cita.getDoctor());
            existingCita.setEspecialidad(cita.getEspecialidad());
            existingCita.setFecha(cita.getFecha());
            existingCita.setHora(cita.getHora());

            return citaRepository.save(existingCita);
        } else {
            return null;
        }
    }

    public void deleteCita(Long id) {
        Cita cita = citaRepository.findById(id).orElse(null);
        if (cita != null) {
            citaRepository.delete(cita);
        }
    }
}

