package com.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.consultorio.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
