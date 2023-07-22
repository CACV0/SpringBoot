package com.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.consultorio.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}

