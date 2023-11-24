package com.neuromind.neuromind.users.controllers;

import com.neuromind.neuromind.users.domain.dto.patient.PatientResponseDTO;
import com.neuromind.neuromind.users.domain.dto.patient.RegisterPatientDTO;
import com.neuromind.neuromind.users.domain.entities.Patient;
import com.neuromind.neuromind.users.exceptions.UserAlreadyExistsException;
import com.neuromind.neuromind.users.exceptions.UserNotFoundException;
import com.neuromind.neuromind.users.services.patients.PatientsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientsService service;

    @PostMapping("/register")
    public ResponseEntity<PatientResponseDTO> register(@Valid @RequestBody RegisterPatientDTO data) {
        try {
            Patient patient = service.register(data);

            PatientResponseDTO registerResponse = new PatientResponseDTO();
            registerResponse.setId(patient.getId());
            registerResponse.setName(patient.getName());
            registerResponse.setEmail(patient.getEmail());
            registerResponse.setBirthDate(patient.getBirthDate());
            registerResponse.setCpf(patient.getCpf());

            return new ResponseEntity<PatientResponseDTO>(registerResponse, HttpStatus.CREATED);
        } catch(UserAlreadyExistsException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Patient>> findAll() {
        List<Patient> patients = service.findAll();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/id")
    public ResponseEntity<Patient> findById(@RequestHeader("patient_id") Long id) {
        Patient patient = service.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        return ResponseEntity.ok(patient);
    }

    @GetMapping("/cpf")
    public ResponseEntity<Patient> findByCpf(@RequestHeader("patient_cpf") String cpf) {
        Patient patient = service.findByCpf(cpf).orElseThrow(() -> new UserNotFoundException("User not found"));
        return ResponseEntity.ok(patient);
    }
}
