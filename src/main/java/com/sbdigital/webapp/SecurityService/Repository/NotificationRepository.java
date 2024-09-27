package com.sbdigital.webapp.SecurityService.Repository;

import com.sbdigital.webapp.SecurityService.Domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserIdAndRead(Long userId, int read);
}