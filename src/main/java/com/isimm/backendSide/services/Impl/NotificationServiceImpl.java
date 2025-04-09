package com.isimm.backendSide.services.Impl;

import com.isimm.backendSide.dto.NotificationDto;
import com.isimm.backendSide.entities.*;
import com.isimm.backendSide.exceptions.RessourceNotFoundException;
import com.isimm.backendSide.mappers.NotificationMapper;
import com.isimm.backendSide.repositories.NotificationRepository;
import com.isimm.backendSide.services.NotificationService;
import com.isimm.backendSide.services.UserService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private UserService userService;

    @Override
    public NotificationDto createNotification(NotificationDto notificationDto) {
        User user = userService.findById(notificationDto.getUserN());
        Notification Notification = NotificationMapper.mapToNotification(notificationDto,user);
        user.getNotifications().add(Notification);
        Notification savedNotification = notificationRepository.save(Notification);
        return NotificationMapper.mapToNotificationDto(savedNotification);
    }
    
    @Override
    public NotificationDto getNotificationById(Long NotificationId) {
        Notification noti = notificationRepository.findById(NotificationId)
                .orElseThrow(()->new RessourceNotFoundException("Notification is not exists with the given id :"+NotificationId));
        return NotificationMapper.mapToNotificationDto(noti);
    }

    @Override
    public List<NotificationDto> getAllNotification() {
        List<Notification> notifications = notificationRepository.findAll();
        return notifications.stream().map((notification)->NotificationMapper.mapToNotificationDto(notification))
                .collect(Collectors.toList());
    }

    @Override
    public NotificationDto updateNotification(Long NotificationId, NotificationDto updatedNotification) {
        Notification Notification = notificationRepository.findById(NotificationId).orElseThrow(
                ()-> new RessourceNotFoundException("Notification is not exists with given id :"+NotificationId));
        Notification.getUserN().getNotifications().remove(Notification);

        Notification.setMessage(updatedNotification.getMessage());
        Notification.setStatus(updatedNotification.getStatus());
        Notification.setNotificationType(updatedNotification.getNotificationType());
        User userN = userService.findById(updatedNotification.getUserN());
        Notification.setUserN(userN);
        userN.getNotifications().add(Notification);
        notificationRepository.save(Notification);
        return NotificationMapper.mapToNotificationDto(Notification);
    }

    @Override
    public void deleteNotification(Long NotificationId) {
        Notification Notification = notificationRepository.findById(NotificationId).orElseThrow(
                ()-> new RessourceNotFoundException("Notification is not exists with given id :"+NotificationId));
        Notification.getUserN().getNotifications().remove(Notification);
        notificationRepository.deleteById(NotificationId);
    }
}
