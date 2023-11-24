package com.neuromind.neuromind.users.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Doctors", uniqueConstraints = { @UniqueConstraint( name = "uk_email_address", columnNames = "email_address"),
        @UniqueConstraint( name = "uk_num_cpf", columnNames = "cpf"),
        @UniqueConstraint( name = "uk_num_crm", columnNames = "crm")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long id;

    private String crm;

    private String specialty;


    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return getPasswordHash();
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
