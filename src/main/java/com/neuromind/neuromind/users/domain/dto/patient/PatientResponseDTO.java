package com.neuromind.neuromind.users.domain.dto.patient;

import java.time.LocalDate;

public class PatientResponseDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String cpf;

    public PatientResponseDTO() {}

    public PatientResponseDTO(Long id, String name, String email, LocalDate birthDate, String cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public PatientResponseDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PatientResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public PatientResponseDTO setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public PatientResponseDTO setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PatientResponseDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}
