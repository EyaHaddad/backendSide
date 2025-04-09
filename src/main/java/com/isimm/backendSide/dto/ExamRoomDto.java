package com.isimm.backendSide.dto;

import java.time.LocalDateTime;

public class ExamRoomDto {
    private Long exam_roomId;
    private Long exam;
    private Long room;
    private LocalDateTime createdAt;

    public ExamRoomDto(Long exam_roomId, Long exam, Long room, LocalDateTime createdAt) {
        this.exam_roomId = exam_roomId;
        this.exam = exam;
        this.room = room;
        this.createdAt = createdAt;
    }

    public Long getExam_roomId() {
        return exam_roomId;
    }

    public void setExam_roomId(Long exam_roomId) {
        this.exam_roomId = exam_roomId;
    }

    public Long getExam() {
        return exam;
    }

    public void setExam(Long exam) {
        this.exam = exam;
    }

    public Long getRoom() {
        return room;
    }

    public void setRoom(Long room) {
        this.room = room;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
