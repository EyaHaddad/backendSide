package com.isimm.backendSide.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "validations")
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long validationId;

    @ManyToOne
    @JoinColumn(name = "examId", nullable = false)
    private Exam examV;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User validatedBy;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ValidationStatus status;

    @Column(columnDefinition = "TEXT")
    private String comments;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime validationDate;

    public Validation() {
        super();
    }

    public Validation(Exam exam, User validatedBy, ValidationStatus status, String comments, LocalDateTime validationDate) {
        super();
        this.examV = exam;
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

    public Exam getExamV() {
        return examV;
    }

    public void setExamV(Exam examV) {
        this.examV = examV;
    }

    public User getValidatedBy() {
        return validatedBy;
    }

    public void setValidatedBy(User validatedBy) {
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
