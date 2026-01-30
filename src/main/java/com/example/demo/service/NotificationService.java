package com.example.demo.service;

import com.example.demo.pojo.dto.CreateNotificationRequest;
import com.example.demo.pojo.entity.Notification;

import java.util.List;

public interface NotificationService
{
    Notification create(CreateNotificationRequest request);

    List<Notification> getAll();
}
