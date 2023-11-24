package com.neuromind.neuromind.shared.medicalRecords.controllers;

import com.neuromind.neuromind.shared.medicalRecords.domain.entities.RecordsFiles;
import com.neuromind.neuromind.shared.medicalRecords.services.RecordFilesService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/upload")
@RequiredArgsConstructor
public class RecordsFilesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RecordsFilesController.class);

    private final RecordFilesService recordFilesService;

    @PostMapping(name = "/files", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public List<RecordsFiles> addFile(@RequestParam("files") MultipartFile[] files){
        LOGGER.debug("Call addFile API");
        return recordFilesService.uploadFiles(files);
    }
}
