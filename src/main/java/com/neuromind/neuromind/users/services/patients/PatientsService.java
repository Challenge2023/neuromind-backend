package com.neuromind.neuromind.users.services.patients;

import com.neuromind.neuromind.users.domain.dto.patient.RegisterPatientDTO;
import com.neuromind.neuromind.users.domain.entities.Patient;
import com.neuromind.neuromind.users.domain.entities.User;
import com.neuromind.neuromind.users.domain.repositories.patient.PatientRepository;
import com.neuromind.neuromind.users.exceptions.UserAlreadyExistsException;
import com.neuromind.neuromind.users.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientsService {
    private final PatientRepository repository;

    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return repository.findPatientByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    public Patient register(RegisterPatientDTO data) throws UserAlreadyExistsException {
        Optional<Patient> foundPatient = repository.findPatientByCpf(data.getCpf());

        if(foundPatient.isPresent()) throw new UserAlreadyExistsException("User already exists");

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());

        String password = data.getPassword();

        String encodedPassword = bCryptPasswordEncoder.encode(password);

        Patient patient = new Patient();
        patient.setName(data.getName());
        patient.setEmail(data.getEmail());
        patient.setPasswordHash(encodedPassword);
        patient.setBirthDate(data.getBirthDate());
        patient.setCpf(data.getCpf());

        return repository.save(patient);
    }

    public Optional<Patient> findById(Long id) {
        Optional<Patient> patient = repository.findById(id);
        if(patient.isEmpty()) throw new UserNotFoundException("User not found");
        return patient;
    }

    public List<Patient> findAll() {
        List<Patient> patients = repository.findAll();
        if(patients.isEmpty()) throw new UserNotFoundException("No patients found");
        return patients;
    }

    public Optional<Patient> findByCpf(String cpf) {
        Optional<Patient> patient = repository.findPatientByCpf(cpf);
        if(patient.isEmpty()) throw new UserNotFoundException("User not found");
        return patient;
    }
}
