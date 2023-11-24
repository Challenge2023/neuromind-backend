package com.neuromind.neuromind.users.domain.dto.doctor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Date;

public class RegisterDoctorDTO {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
     private String password;
     private LocalDate birthDate;
     @NotBlank
     @Size(max = 11)
     private String cpf;
     @NotBlank
     @Size(max = 20)
     private String crm;
     @NotBlank
     private String specialty;

     public RegisterDoctorDTO() {}

    public RegisterDoctorDTO(String name, String email, String password, LocalDate birthDate, String cpf, String crm, String specialty) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.crm = crm;
        this.specialty = specialty;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
