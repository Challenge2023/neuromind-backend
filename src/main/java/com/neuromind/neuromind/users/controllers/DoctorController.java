package com.neuromind.neuromind.users.controllers;

import com.neuromind.neuromind.users.domain.dto.doctor.DoctorResponseDTO;
import com.neuromind.neuromind.users.domain.dto.doctor.RegisterDoctorDTO;

import com.neuromind.neuromind.users.domain.entities.Doctor;
import com.neuromind.neuromind.users.exceptions.UserAlreadyExistsException;
import com.neuromind.neuromind.users.exceptions.UserNotFoundException;
import com.neuromind.neuromind.users.services.doctors.DoctorsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorsService service;

    @PostMapping("/register")
    public ResponseEntity<DoctorResponseDTO> registerDoctor(@Valid @RequestBody RegisterDoctorDTO registerDto) {
        try {
            Doctor doctor = service.register(registerDto);

            DoctorResponseDTO registerResponse = new DoctorResponseDTO();
            registerResponse.setId(doctor.getId());
            registerResponse.setName(doctor.getName());
            registerResponse.setEmail(doctor.getEmail());
            registerResponse.setBirthDate(doctor.getBirthDate());
            registerResponse.setCrm(doctor.getCrm());
            registerResponse.setCpf(doctor.getCpf());
            registerResponse.setSpecialty(doctor.getSpecialty());

            return new ResponseEntity<DoctorResponseDTO>(registerResponse, HttpStatus.CREATED);

        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id")
    public ResponseEntity<Doctor> findById(@RequestHeader("doctor_id") Long id) {
        Doctor doctor = service.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        return ResponseEntity.ok(doctor);
    }

    @GetMapping("/crm")
    public ResponseEntity<Doctor> findByCrm(@RequestHeader("doctor_crm") String crm) {
        Doctor doctor = service.findByCrm(crm).orElseThrow(() -> new UserNotFoundException("User not found"));
        return ResponseEntity.ok(doctor);
    }
}
