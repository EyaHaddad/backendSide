package com.isimm.backendSide.dto;

import com.isimm.backendSide.entities.ValidationStatus;
import java.time.LocalDateTime;

public class ValidationDto {
    private Long validationId;
    private Long exam;
    private Long validatedBy;
    private ValidationStatus status;
    private String comments;
    private LocalDateTime validationDate;

    public ValidationDto(Long validationId, Long exam, Long validatedBy, ValidationStatus status, String comments, LocalDateTime validationDate) {
        this.validationId = validationId;
        this.exam = exam;
        this.validatedBy = validatedBy;
        this.status = status;
        this.comments = comments;
        this.validationDate = validationDate;
    }

    public Long getValidationId() {
        return validationId;
    }

    public void setValidationId(Long validationId) {
        this.validationId = validationId;
    }

    public Long getexam() {
        return exam;
    }

    public void setexam(Long exam) {
        this.exam = exam;
    }

    public Long getValidatedBy() {
        return validatedBy;
    }

    public void setValidatedBy(Long validatedBy) {
        this.validatedBy = validatedBy;
    }

    public ValidationStatus getStatus() {
        return status;
    }

    public void setStatus(ValidationStatus status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(LocalDateTime validationDate) {
        this.validationDate = validationDate;
    }
}
