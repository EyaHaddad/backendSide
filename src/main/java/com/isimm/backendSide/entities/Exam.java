package com.isimm.backendSide.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;

    @Column(nullable = false, length = 100)
    private String subject;

    @ManyToOne
    @JoinColumn(name = "departmentId", nullable = true)
    private Department departmentE;

    @Column(nullable = true)
    private LocalDate examDate;

    @Column(nullable = true)
    private LocalTime startTime;

    @Column(nullable = true)
    private LocalTime endTime;

    @Column(nullable = true)
    @Min(1)
    @Max(5)
    private int difficulty;

    @Column(nullable = true)
    private int coefficient;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = true)
    private Boolean isDuplicate;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<ExamRoom> examRooms= new ArrayList<>();

    @OneToMany(mappedBy = "examS", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<ExamStudent> examStudents= new ArrayList<>();

    @OneToMany(mappedBy = "examV",cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Validation> validations= new ArrayList<>();

    @OneToMany(mappedBy = "exam",cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Invigilator> invigilators= new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Exam() {
        super();
    }

    public Exam(Long examId, String subject, Department departmentE, LocalDate examDate, LocalTime startTime, LocalTime endTime, int difficulty, int coefficient,Boolean dup) {
        super();
        this.examId = examId;
        this.subject = subject;
        this.departmentE = departmentE;
        this.examDate = examDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.difficulty = difficulty;
        this.coefficient = coefficient;
        //pour la duplication je dois faire une recherche et affectuer la valeur
        this.isDuplicate= dup;
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

    public Department getDepartmentE() {
        return departmentE;
    }

    public void setDepartmentE(Department departmentE) {
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

    public Collection<ExamRoom> getExamRooms() {
        return examRooms;
    }

    public void setExamRooms(Collection<ExamRoom> examRooms) {
        this.examRooms = examRooms;
    }

    public Collection<Validation> getValidations() {
        return validations;
    }

    public void setValidations(Collection<Validation> validations) {
        this.validations = validations;
    }

    public Collection<Invigilator> getInvigilators() {
        return invigilators;
    }

    public Collection<ExamStudent> getExamStudents() {
        return examStudents;
    }

    public void setExamStudents(Collection<ExamStudent> examStudents) {
        this.examStudents = examStudents;
    }

    public void setInvigilators(Collection<Invigilator> invigilators) {
        this.invigilators = invigilators;
    }
}
