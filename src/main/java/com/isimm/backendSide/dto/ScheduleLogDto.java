package com.isimm.backendSide.dto;

import java.time.LocalDateTime;

public class ScheduleLogDto {
    private Long logId;
    private String action;
    private String description;
    private Long performedBy;
    private LocalDateTime timestamp;

    public ScheduleLogDto(Long logId, String action, String description, Long performedBy, LocalDateTime timestamp) {
        this.logId = logId;
        this.action = action;
        this.description = description;
        this.performedBy = performedBy;
        this.timestamp = timestamp;
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(Long performedBy) {
        this.performedBy = performedBy;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
