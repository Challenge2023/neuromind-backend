package com.neuromind.neuromind.shared.medicalRecords.services;

import com.neuromind.neuromind.shared.medicalRecords.domain.dto.RegisterMedicalRecordDTO;
import com.neuromind.neuromind.shared.medicalRecords.domain.entities.MedicalRecords;
import com.neuromind.neuromind.shared.medicalRecords.domain.repositories.MedicalRecordsRepository;
import com.neuromind.neuromind.users.domain.entities.Patient;
import com.neuromind.neuromind.users.domain.repositories.patient.PatientRepository;
import com.neuromind.neuromind.users.exceptions.UserNotFoundException;
import com.neuromind.neuromind.users.services.patients.PatientsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicalRecordsService {
    private final MedicalRecordsRepository repository;
    private final PatientsService patientsService;


    public MedicalRecords register(RegisterMedicalRecordDTO data) {
        Optional<Patient> patient = patientsService.findById(data.getPatientId());
        com.neuromind.neuromind.shared.medicalRecords.domain.entities.MedicalRecords medicalRecords = new com.neuromind.neuromind.shared.medicalRecords.domain.entities.MedicalRecords();
        if(patient.isPresent()) {

            medicalRecords.setPatient(patient.get());
            medicalRecords.setDocumentBody(data.getDocumentBody());
        }
        return repository.save(medicalRecords);
    };

    public Optional<MedicalRecords> findById(Long id) {
        Optional<MedicalRecords> medicalRecords = repository.findById(id);

        if(medicalRecords.isEmpty()) throw new UserNotFoundException("Medical record not found");

        return medicalRecords;
    }

    public List<MedicalRecords> findAllByPatient(Long id, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAllByPatient_Id(id, pageable);
    }
}
