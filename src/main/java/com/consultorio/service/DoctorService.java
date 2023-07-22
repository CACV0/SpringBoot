package com.consultorio.service;

import com.consultorio.model.Doctor;
import com.consultorio.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctores() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor doctor) {
        Doctor existingDoctor = doctorRepository.findById(id).orElse(null);
        if (existingDoctor != null) {
            existingDoctor.setNombre(doctor.getNombre());
            existingDoctor.setApellido(doctor.getApellido());
            existingDoctor.setEspecialidad(doctor.getEspecialidad());
            existingDoctor.setConsultorio(doctor.getConsultorio());
            existingDoctor.setCorreo(doctor.getCorreo());

            return doctorRepository.save(existingDoctor);
        } else {
            return null;
        }
    }

    public void deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        if (doctor != null) {
            doctorRepository.delete(doctor);
        }
    }
}
