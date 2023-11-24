package com.neuromind.neuromind.users.domain.repositories.doctor;

import com.neuromind.neuromind.users.domain.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    public Optional<Doctor> findDoctorByCrm(String crm);
    public UserDetails findDoctorByEmail(String email);
}
