package com.consultorio.service;

import com.consultorio.model.Paciente;
import com.consultorio.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente getPacienteById(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public Paciente createPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente updatePaciente(Long id, Paciente paciente) {
        Paciente existingPaciente = pacienteRepository.findById(id).orElse(null);
        if (existingPaciente != null) {
            existingPaciente.setNombre(paciente.getNombre());
            existingPaciente.setCedula(paciente.getCedula());
            existingPaciente.setApellido(paciente.getApellido());
            existingPaciente.setEdad(paciente.getEdad());
            existingPaciente.setTelefono(paciente.getTelefono());

            return pacienteRepository.save(existingPaciente);
        } else {
            return null;
        }
    }

    public void deletePaciente(Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        if (paciente != null) {
            pacienteRepository.delete(paciente);
        }
    }
}
