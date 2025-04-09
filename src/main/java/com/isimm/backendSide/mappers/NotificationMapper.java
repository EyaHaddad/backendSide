package com.isimm.backendSide.mappers;

import com.isimm.backendSide.dto.NotificationDto;
import com.isimm.backendSide.entities.Notification;
import com.isimm.backendSide.entities.User;

public class NotificationMapper {
    public static NotificationDto mapToNotificationDto(Notification notification){
        return new NotificationDto(
                notification.getNotificationId(),
                notification.getUserN().getUserId(),
                notification.getMessage(),
                notification.getStatus(),
                notification.getNotificationType(),
                notification.getCreatedAt().toString()
        );
    }
    public static Notification mapToNotification(NotificationDto notificationDto, User user){
        return new Notification(
                user,
                notificationDto.getMessage(),
                notificationDto.getStatus(),
                notificationDto.getNotificationType()
        );
    }
}
