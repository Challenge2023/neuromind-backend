package com.neuromind.neuromind.users.domain.repositories.patient;

import com.neuromind.neuromind.shared.medicalRecords.domain.entities.MedicalRecords;
import com.neuromind.neuromind.users.domain.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface PatientRepository  extends JpaRepository<Patient, Long> {
    public Optional<Patient> findPatientByCpf(String cpf);
    public Optional<Patient> findPatientByEmail(String email);
}
