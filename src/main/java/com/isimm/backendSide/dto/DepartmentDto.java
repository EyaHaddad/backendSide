package com.isimm.backendSide.dto;

import com.isimm.backendSide.entities.User;

import java.time.LocalDateTime;

public class DepartmentDto {
    private Long departmentId;
    private String name;
    private User head;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public DepartmentDto(Long departmentId, String name, User head, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.departmentId = departmentId;
        this.name = name;
        this.head = head;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getHead() {
        return head;
    }

    public void setHead(User head) {
        this.head = head;
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
}
