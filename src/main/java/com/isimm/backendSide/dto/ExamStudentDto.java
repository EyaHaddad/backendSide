package com.isimm.backendSide.dto;

import com.isimm.backendSide.entities.Exam;
import com.isimm.backendSide.entities.ParticipationStatus;
import com.isimm.backendSide.entities.Student;

import java.time.LocalDateTime;

public class ExamStudentDto {
    private Long exam_studentId;
    private Long examS;
    private Long student;
    private ParticipationStatus status;
    private LocalDateTime createdAt;

    public ExamStudentDto(Long exam_studentId, Long examS, Long student, ParticipationStatus status, LocalDateTime createdAt) {
        this.exam_studentId = exam_studentId;
        this.examS = examS;
        this.student = student;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getExam_studentId() {
        return exam_studentId;
    }

    public void setExam_studentId(Long exam_studentId) {
        this.exam_studentId = exam_studentId;
    }

    public Long getExamS() {
        return examS;
    }

    public void setExamS(Long examS) {
        this.examS = examS;
    }

    public Long getStudent() {
        return student;
    }

    public void setStudent(Long student) {
        this.student = student;
    }

    public ParticipationStatus getStatus() {
        return status;
    }

    public void setStatus(ParticipationStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
