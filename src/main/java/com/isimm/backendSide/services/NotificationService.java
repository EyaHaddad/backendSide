package com.isimm.backendSide.services;

import com.isimm.backendSide.dto.NotificationDto;
import com.isimm.backendSide.entities.Notification;

import java.util.List;

public interface NotificationService {
    NotificationDto createNotification(NotificationDto NotificationDto);
    NotificationDto getNotificationById (Long NotificationId);
    List<NotificationDto> getAllNotification();
    NotificationDto updateNotification(Long NotificationId, NotificationDto updatedNotification);
    void deleteNotification (Long NotificationId);
}
