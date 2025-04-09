package com.isimm.backendSide.controllers;

import com.isimm.backendSide.dto.NotificationDto;
import com.isimm.backendSide.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    //Build Add Notification REST API
    @PostMapping
    public ResponseEntity<NotificationDto> createNotification(@RequestBody NotificationDto NotificationDto){
        NotificationDto savedNotification = notificationService.createNotification(NotificationDto);
        return new ResponseEntity<>(savedNotification, HttpStatus.CREATED);
    }
    //Build Get Notification REST API
    @GetMapping("{id}")
    public ResponseEntity<NotificationDto> getNotificationById(@PathVariable("id") Long id){
        NotificationDto NotificationDto = notificationService.getNotificationById(id);
        return ResponseEntity.ok(NotificationDto);
    }
    //Build Get All Notifications REST API
    @GetMapping
    public ResponseEntity<List<NotificationDto>> getAllNotification(){
        List<NotificationDto> Notifications = notificationService.getAllNotification();
        return ResponseEntity.ok(Notifications);
    }
    //Build Update Notification REST API
    @PutMapping("{id}")
    public ResponseEntity<NotificationDto> updateNotification(@PathVariable("id") Long id,
                                                          @RequestBody NotificationDto updatedNotification){
        NotificationDto NotificationDto =notificationService.updateNotification(id,updatedNotification);
        return ResponseEntity.ok(NotificationDto);
    }
    //Build Delete Notification REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable("id") Long id){
        notificationService.deleteNotification(id);
        return ResponseEntity.ok("Notification deleted successfully!");
    }
}
