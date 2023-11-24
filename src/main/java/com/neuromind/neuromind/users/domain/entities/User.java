package com.neuromind.neuromind.users.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
public abstract class User implements UserDetails {
    @Column(name = "full_name")
    private String name;
    @Column(name = "email_address")
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;
    @Column(name = "date_birth")
    private LocalDate birthDate;

    private String cpf;
}
