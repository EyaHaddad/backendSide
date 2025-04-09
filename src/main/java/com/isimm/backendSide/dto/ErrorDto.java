package com.isimm.backendSide.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor

public class ErrorDto {
    private String message;

    public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
        this.message = message;
    }
}
