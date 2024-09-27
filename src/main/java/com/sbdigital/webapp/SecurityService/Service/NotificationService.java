package com.sbdigital.webapp.SecurityService.Service;

import com.sbdigital.webapp.SecurityService.Domain.Notification;
import com.sbdigital.webapp.SecurityService.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Notification> saveAllNotifications(List<Notification> notifications) {
        return notificationRepository.saveAll(notifications);
    }
    public Notification updateNotificationReadStatus(Long notificationId, Long userId, int read) {
        Optional<Notification> optionalNotification = notificationRepository.findById(notificationId);
        if (optionalNotification.isPresent()) {
            Notification notification = optionalNotification.get();
            if (notification.getUserId().equals(userId)) {
                notification.setRead(read);
                return notificationRepository.save(notification);
            } else {
                throw new RuntimeException("Notification not found with notificationId: " + notificationId + " and userId: " + userId);
            }
        } else {
            throw new RuntimeException("Notification not found with notificationId: " + notificationId);
        }
    }
}
