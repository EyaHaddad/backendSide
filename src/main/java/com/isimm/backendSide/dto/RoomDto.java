package com.isimm.backendSide.dto;

import java.time.LocalDateTime;

public class RoomDto {
    private Long roomId;
    private String roomName;
    private int capacity;
    private String location;
    private LocalDateTime updatedAt;
    private Boolean isAvailable;

    public RoomDto(Long roomId, String roomName, int capacity, String location, LocalDateTime updatedAt,Boolean avail) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.capacity = capacity;
        this.location = location;
        this.updatedAt = updatedAt;
        this.isAvailable = avail;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
