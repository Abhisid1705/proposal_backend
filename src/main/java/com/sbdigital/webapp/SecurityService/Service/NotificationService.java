package com.sbdigital.webapp.SecurityService.Service;

import com.sbdigital.webapp.SecurityService.Domain.Notification;
import com.sbdigital.webapp.SecurityService.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public List<Notification> getNotificationsByUserIdAndRead(Long userId, int read) {
        return notificationRepository.findByUserIdAndRead(userId, read);
    }
}