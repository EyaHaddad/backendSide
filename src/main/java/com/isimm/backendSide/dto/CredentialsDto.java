package com.isimm.backendSide.dto;

public class CredentialsDto {
    private String email;
    private char[]  password;
    private boolean rememberMe;

    public CredentialsDto(String email, char[] password, boolean rememberMe) {
        this.email = email;
        this.password = password;
        this.rememberMe=rememberMe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
    public boolean getRememberMe() {
        return rememberMe;
    }
    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
