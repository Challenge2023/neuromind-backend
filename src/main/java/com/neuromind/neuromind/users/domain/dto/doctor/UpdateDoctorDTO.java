package com.neuromind.neuromind.users.domain.dto.doctor;

import jakarta.validation.constraints.Email;

public class UpdateDoctorDTO {
    private String name;
    @Email
    private String email;
    private String password;

    private String specialty;

    public UpdateDoctorDTO() {}

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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
