package com.isimm.backendSide.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "exam_room")
public class ExamRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exam_roomId;

    @ManyToOne
    @JoinColumn(name = "examId", nullable = false)
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "roomId", nullable = false)
    private Room room;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public ExamRoom() {
        super();
    }

    public ExamRoom(Long exam_roomId,Exam exam, Room room) {
        super();
        this.exam_roomId=exam_roomId;
        this.exam = exam;
        this.room = room;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Long getExam_roomId() {
        return exam_roomId;
    }

    public void setExam_roomId(Long exam_roomId) {
        this.exam_roomId = exam_roomId;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
