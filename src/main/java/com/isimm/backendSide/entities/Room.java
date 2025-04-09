package com.isimm.backendSide.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(nullable = false, length = 50)
    private String roomName;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false, length = 100)
    private String location;

    @Column(nullable = false)
    private Boolean isAvailable;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<ExamRoom> examRooms= new ArrayList<>();

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Invigilator> invigilators= new ArrayList<>();

    public Room() {
        super();
    }

    public Room(Long id ,String roomName, int capacity, String location, Boolean avail) {
        super();
        this.roomId = id;
        this.roomName = roomName;
        this.capacity = capacity;
        this.location = location;
        this.isAvailable=avail;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
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

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
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

    public Collection<ExamRoom> getExamRooms() {
        return examRooms;
    }

    public void setExamRooms(Collection<ExamRoom> examRooms) {
        this.examRooms = examRooms;
    }

    public Collection<Invigilator> getInvigilators() {
        return invigilators;
    }

    public void setInvigilators(Collection<Invigilator> invigilators) {
        this.invigilators = invigilators;
    }
}
