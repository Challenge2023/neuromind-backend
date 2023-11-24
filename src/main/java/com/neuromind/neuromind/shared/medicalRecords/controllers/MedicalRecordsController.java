package com.neuromind.neuromind.shared.medicalRecords.controllers;
import com.neuromind.neuromind.shared.medicalRecords.domain.dto.RegisterMedicalRecordDTO;
import com.neuromind.neuromind.shared.medicalRecords.domain.entities.MedicalRecords;
import com.neuromind.neuromind.shared.medicalRecords.services.MedicalRecordsService;
import com.neuromind.neuromind.users.exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
@RequiredArgsConstructor
public class MedicalRecordsController {
    private final MedicalRecordsService service;

    @PostMapping("/register")
    public ResponseEntity<MedicalRecords> register(@Valid @RequestBody RegisterMedicalRecordDTO data) {
        MedicalRecords medicalRecords = service.register(data);
        return new ResponseEntity<MedicalRecords>(medicalRecords, HttpStatus.CREATED);
    }


    @GetMapping("/id")
    public ResponseEntity<MedicalRecords> findById(@RequestHeader("record_id") Long id) {
        MedicalRecords medicalRecords = service.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        return ResponseEntity.ok(medicalRecords);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<List<MedicalRecords>> delete(@RequestHeader("patient_id") Long id, @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        List<MedicalRecords> medicalRecords = service.findAllByPatient(id, page, size);
        return ResponseEntity.ok(medicalRecords);
    }
}
