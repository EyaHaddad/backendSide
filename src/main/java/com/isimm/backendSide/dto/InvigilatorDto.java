package com.isimm.backendSide.dto;

import java.time.LocalDateTime;

public class InvigilatorDto {
    private Long invigilatorId;
    private Long user;
    private Long exam;
    private Long room;
    private LocalDateTime createdAt;

    public InvigilatorDto(Long invigilatorId, Long user, Long exam, Long room) {
        this.invigilatorId = invigilatorId;
        this.user = user;
        this.exam = exam;
        this.room = room;
    }

    public Long getInvigilatorId() {
        return invigilatorId;
    }

    public void setInvigilatorId(Long invigilatorId) {
        this.invigilatorId = invigilatorId;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
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
