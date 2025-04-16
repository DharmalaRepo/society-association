package com.tech.society.association.services;

import com.tech.society.association.models.Notification;
import java.util.List;

public interface NotificationService {
    Notification save(Notification notification);
    List<Notification> findAll();
    Notification findById(String id);
    void deleteById(String id);
}