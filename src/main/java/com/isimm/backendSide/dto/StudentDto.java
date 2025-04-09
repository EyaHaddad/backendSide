package com.isimm.backendSide.dto;

import com.isimm.backendSide.entities.Role;
import com.isimm.backendSide.entities.User;

import java.time.LocalDateTime;

public class StudentDto {
    private Long studentId;
    private String name;
    private String email;
    private String password;
    private Role role;
    private String departmentU;
    private String program;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public StudentDto(Long studentId, String name, String email, String password, Role role, String departmentU, String program, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.departmentU = departmentU;
        this.program = program;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getDepartmentU() {
        return departmentU;
    }

    public void setDepartmentU(String departmentU) {
        this.departmentU = departmentU;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
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
