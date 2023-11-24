package com.neuromind.neuromind.shared.medicalRecords.domain.repositories;

import com.neuromind.neuromind.shared.medicalRecords.domain.entities.MedicalRecords;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalRecordsRepository extends JpaRepository<MedicalRecords, Long> {
    List<MedicalRecords> findAllByPatient_Id(Long id, Pageable pageable);
}
