package com.neuromind.neuromind.users.services.doctors;

import com.neuromind.neuromind.users.domain.dto.doctor.RegisterDoctorDTO;
import com.neuromind.neuromind.users.domain.entities.Doctor;
import com.neuromind.neuromind.users.domain.repositories.doctor.DoctorRepository;
import com.neuromind.neuromind.users.exceptions.UserAlreadyExistsException;
import com.neuromind.neuromind.users.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorsService {
    private final DoctorRepository repository;


    public Doctor register(RegisterDoctorDTO registerDto) throws UserAlreadyExistsException {
        Optional<Doctor> foundDoctor = repository.findDoctorByCrm(registerDto.getCrm());

        if(foundDoctor.isPresent()) throw new UserAlreadyExistsException("User already exists");

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());

        String password = registerDto.getPassword();

        String encodedPassword = bCryptPasswordEncoder.encode(password);

        Doctor doctor = new Doctor();
        doctor.setName(registerDto.getName());
        doctor.setEmail(registerDto.getEmail());
        doctor.setPasswordHash(encodedPassword);
        doctor.setBirthDate(registerDto.getBirthDate());
        doctor.setCpf(registerDto.getCpf());
        doctor.setCrm(registerDto.getCrm());
        doctor.setSpecialty(registerDto.getSpecialty());

        return repository.save(doctor);
    }

    public Optional<Doctor> findById(Long id) {
        Optional<Doctor> doctor = repository.findById(id);
        if(doctor.isEmpty()) throw new UserNotFoundException("User not found");
        return doctor;
    }

    public Optional<Doctor> findByCrm(String crm) {
        Optional<Doctor> doctor = repository.findDoctorByCrm(crm);
        if(doctor.isEmpty()) throw new UserNotFoundException("User not found");
        return doctor;
    }

}
