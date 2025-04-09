package com.isimm.backendSide.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ExamDto {
    private Long examId;
    private String subject;
    private String departmentE;
    private LocalDate examDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private int difficulty;
    private int coefficient;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isDuplicate;

    public ExamDto(Long examId, String subject, String departmentE, LocalDate examDate, LocalTime startTime, LocalTime endTime, int difficulty, int coefficient, LocalDateTime createdAt, LocalDateTime updatedAt, Boolean isDuplicate) {
        this.examId = examId;
        this.subject = subject;
        this.departmentE = departmentE;
        this.examDate = examDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.difficulty = difficulty;
        this.coefficient = coefficient;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isDuplicate = isDuplicate;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDepartmentE() {
        return departmentE;
    }

    public void setDepartmentE(String departmentE) {
        this.departmentE = departmentE;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getDuplicate() {
        return isDuplicate;
    }

    public void setDuplicate(Boolean duplicate) {
        isDuplicate = duplicate;
    }
}
