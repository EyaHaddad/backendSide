package com.isimm.backendSide.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column( length = 100)
    private String name;

    @Column(length = 100, unique = true)
    private String email;

    @Column(length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column()
    private Role role;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departmentId")
    private Department departmentU;

    @CreationTimestamp
    @Column( updatable = false)
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column()
    private LocalDateTime updatedAt;

    @Column()
    private boolean isActive;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Invigilator> invigilators= new ArrayList<>();

    @OneToMany(mappedBy = "performedBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<ScheduleLog> scheduleLogs= new ArrayList<>();

    @OneToOne(mappedBy = "userStud", cascade = CascadeType.ALL)
    private Student student;

    @OneToMany(mappedBy = "userN", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Notification> notifications= new ArrayList<>();

    @OneToMany(mappedBy = "validatedBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Validation> validations= new ArrayList<>();

    public User() {
        super();
    }

    public User(Long id,String name, String email, String password, Role role, Department departmentU,
                Boolean isActive) {
        super();
        this.userId=id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.departmentU = departmentU;
        this.isActive=isActive;
    }

    public User(String name, String email, String password, Role role, Department departmentU,Boolean isActive) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.departmentU = departmentU;
        this.isActive=isActive;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
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

    public boolean getIsActive() {
        return isActive;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setDepartmentU(Department departmentU) {
        this.departmentU = departmentU;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setInvigilators(Collection<Invigilator> invigilators) {
        this.invigilators = invigilators;
    }

    public void setScheduleLogs(Collection<ScheduleLog> scheduleLogs) {
        this.scheduleLogs = scheduleLogs;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setNotifications(Collection<Notification> notifications) {
        this.notifications = notifications;
    }

    public void setValidations(Collection<Validation> validations) {
        this.validations = validations;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public Department getDepartmentU() {
        return departmentU;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public Collection<Invigilator> getInvigilators() {
        return invigilators;
    }

    public Collection<ScheduleLog> getScheduleLogs() {
        return scheduleLogs;
    }

    public Student getStudent() {
        return student;
    }

    public Collection<Notification> getNotifications() {
        return notifications;
    }

    public Collection<Validation> getValidations() {
        return validations;
    }
}

