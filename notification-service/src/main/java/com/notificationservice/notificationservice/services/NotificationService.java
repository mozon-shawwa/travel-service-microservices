package com.notificationservice.notificationservice.services;

import com.notificationservice.notificationservice.models.Notification;
import com.notificationservice.notificationservice.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public Notification sendNotification(Notification notification) {
        notification.setStatus("SENT");
        System.out.println(">>> Sending Notification to Customer " + notification.getCustomerId() + ": " + notification.getMessage());
        return notificationRepository.save(notification);
    }
}