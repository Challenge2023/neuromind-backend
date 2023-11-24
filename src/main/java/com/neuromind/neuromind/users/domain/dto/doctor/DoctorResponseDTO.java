package com.neuromind.neuromind.users.domain.dto.doctor;

import java.time.LocalDate;
import java.util.Date;

public class DoctorResponseDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String cpf;
    private String crm;
    private String specialty;

    public DoctorResponseDTO() {
    }

    public DoctorResponseDTO(Long id, String name, String email, LocalDate birthDate, String cpf, String crm, String specialty) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.crm = crm;
        this.specialty = specialty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
