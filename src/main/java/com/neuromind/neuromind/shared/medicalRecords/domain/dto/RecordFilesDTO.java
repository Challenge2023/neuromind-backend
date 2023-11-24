package com.neuromind.neuromind.shared.medicalRecords.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecordFilesDTO {
    @NotBlank
    private String fileName;
    @NotBlank
    private String fileUrl;

}
