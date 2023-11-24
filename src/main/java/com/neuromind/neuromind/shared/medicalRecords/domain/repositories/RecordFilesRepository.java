package com.neuromind.neuromind.shared.medicalRecords.domain.repositories;

import com.neuromind.neuromind.shared.medicalRecords.domain.entities.RecordsFiles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordFilesRepository extends JpaRepository<RecordsFiles, Long> {

}
