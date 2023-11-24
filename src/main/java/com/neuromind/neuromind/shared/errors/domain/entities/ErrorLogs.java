package com.neuromind.neuromind.shared.errors.domain.entities;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.ISBN;

import java.time.LocalDateTime;

@Entity
@Table(name = "ERROR_LOGS")
public class ErrorLogs {
    @Id
    @Column(name = "log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "error_date")
    private LocalDateTime errorDate;
    @Column(name = "error_code")
    private String errorCode;

    @Column(name = "error_message")
    private String errorMessage;

    public ErrorLogs() {}

    public ErrorLogs(Long id, String userName, LocalDateTime errorDate, String errorCode, String errorMessage) {
        this.id = id;
        this.userName = userName;
        this.errorDate = errorDate;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }


    public Long getId() {
        return id;
    }

    public ErrorLogs setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public ErrorLogs setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public LocalDateTime getErrorDate() {
        return errorDate;
    }

    public ErrorLogs setErrorDate(LocalDateTime errorDate) {
        this.errorDate = errorDate;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public ErrorLogs setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public ErrorLogs setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
}
