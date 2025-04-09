package com.isimm.backendSide.dto;

import com.isimm.backendSide.entities.NotificationStatus;
import com.isimm.backendSide.entities.NotificationType;

public class NotificationDto {
    private Long notificationId;
    private Long userN;
    private String message;
    private NotificationStatus status;
    private NotificationType notificationType;
    private String createdAt;

    public NotificationDto(Long notificationId, Long userN, String message, NotificationStatus status, NotificationType notificationType, String createdAt) {
        this.notificationId = notificationId;
        this.userN = userN;
        this.message = message;
        this.status = status;
        this.notificationType = notificationType;
        this.createdAt = createdAt;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public Long getUserN() {
        return userN;
    }

    public void setUserN(Long userN) {
        this.userN = userN;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
