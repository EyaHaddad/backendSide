package com.isimm.backendSide.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "exam_student")
public class ExamStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exam_studentId;

    @ManyToOne
    @JoinColumn(name = "examId", nullable = false)
    private Exam examS;

    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false)
    private Student student;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ParticipationStatus status;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public ExamStudent() {
        super();
    }

    public ExamStudent(Long id,Exam examS, Student student, ParticipationStatus status) {
        super();
        this.exam_studentId=id;
        this.examS = examS;
        this.student = student;
        this.status = status;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Long getExam_studentId() {
        return exam_studentId;
    }

    public void setExam_studentId(Long exam_studentId) {
        this.exam_studentId = exam_studentId;
    }

    public Exam getExamS() {
        return examS;
    }

    public void setExamS(Exam examS) {
        this.examS = examS;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
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
