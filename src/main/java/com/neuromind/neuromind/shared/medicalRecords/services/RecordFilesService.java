package com.neuromind.neuromind.shared.medicalRecords.services;

import com.neuromind.neuromind.shared.medicalRecords.domain.dto.RecordFilesDTO;
import com.neuromind.neuromind.shared.medicalRecords.domain.entities.RecordsFiles;
import com.neuromind.neuromind.shared.medicalRecords.domain.repositories.RecordFilesRepository;
import com.neuromind.neuromind.shared.medicalRecords.exceptions.BadRequestException;
import com.neuromind.neuromind.shared.medicalRecords.exceptions.GCPFileUploadException;
import com.neuromind.neuromind.shared.medicalRecords.util.DataBucketUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RecordFilesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecordFilesService.class);

    private final RecordFilesRepository repository;


    private final DataBucketUtil dataBucketUtil;

    public List<RecordsFiles> uploadFiles(MultipartFile[] files) {

        LOGGER.debug("Start file uploading service");
        List<RecordsFiles> inputFiles = new ArrayList<>();

        Arrays.asList(files).forEach(file -> {
            String originalFileName = file.getOriginalFilename();
            if(originalFileName == null){
                throw new BadRequestException("Original file name is null");
            }
            Path path = new File(originalFileName).toPath();

            try {
                String contentType = Files.probeContentType(path);
                RecordFilesDTO fileDto = dataBucketUtil.uploadFile(file, originalFileName, contentType);

                if (fileDto != null) {
                    inputFiles.add(new RecordsFiles(fileDto.getFileName(), fileDto.getFileUrl()));
                    LOGGER.debug("File uploaded successfully, file name: {} and url: {}",fileDto.getFileName(), fileDto.getFileUrl() );
                }
            } catch (Exception e) {
                LOGGER.error("Error occurred while uploading. Error: ", e);
                throw new GCPFileUploadException("Error occurred while uploading");
            }
        });

        repository.saveAll(inputFiles);
        LOGGER.debug("File details successfully saved in the database");
        return inputFiles;
    }
}
