package com.neuromind.neuromind.shared.medicalRecords.domain.dto;

import com.neuromind.neuromind.users.domain.entities.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Clob;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterMedicalRecordDTO {
    private Long patientId;

    private Clob documentBody;
}
