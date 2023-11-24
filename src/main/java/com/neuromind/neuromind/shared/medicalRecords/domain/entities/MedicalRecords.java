package com.neuromind.neuromind.shared.medicalRecords.domain.entities;

import com.neuromind.neuromind.users.domain.entities.Patient;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Clob;
import java.time.LocalDateTime;

@Entity
@Table(name = "MEDICAL_RECORDS")
public class MedicalRecords {
    @Id
    @Column(name = "record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(
            name = "patient_id",
            referencedColumnName = "patient_id",
            foreignKey = @ForeignKey(
                    name = "fk_record_patient",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Patient patient;

    @Column(name ="document_body")
    @Lob
    private Clob documentBody;


    @Column(name ="creation_date")
    @CreatedDate
    private LocalDateTime creationDate;

    public MedicalRecords() {

    }

    public MedicalRecords(Long id, Patient patient, Clob documentBody, LocalDateTime creationDate) {
        this.id = id;
        this.patient = patient;
        this.documentBody = documentBody;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public MedicalRecords setId(Long id) {
        this.id = id;
        return this;
    }

    public Patient getPatient() {
        return patient;
    }

    public MedicalRecords setPatient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public Clob getDocumentBody() {
        return documentBody;
    }

    public void setDocumentBody(Clob documentBody) {
        this.documentBody = documentBody;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public MedicalRecords setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }
}
