package com.sbdigital.webapp.SecurityService.Controller;

import com.sbdigital.webapp.SecurityService.Domain.Notification;
import com.sbdigital.webapp.SecurityService.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @GetMapping("/user/{userId}/read/{read}")
    public List<Notification> getNotificationsByUserIdAndRead(@PathVariable Long userId, @PathVariable int read) {
        return notificationService.getNotificationsByUserIdAndRead(userId, read);
    }
}