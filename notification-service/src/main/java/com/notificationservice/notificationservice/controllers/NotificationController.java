package com.notificationservice.notificationservice.controllers;

import com.notificationservice.notificationservice.models.Notification;
import com.notificationservice.notificationservice.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/send")
    public Notification send(@RequestBody Notification notification) {
        return notificationService.sendNotification(notification);
    }
}