package com.isimm.backendSide.dto;

import com.isimm.backendSide.entities.Department;
import com.isimm.backendSide.entities.Role;

import java.time.LocalDateTime;

public class UserDto {
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String token;

    public UserDto(Long userId,String email, String name,String password) {
        this.userId = userId;
        this.name=name;
        this.email = email;
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
