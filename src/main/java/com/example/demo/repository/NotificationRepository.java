package com.example.demo.repository;

import com.example.demo.pojo.entity.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository
        extends CrudRepository<Notification, Integer>
{
    List<Notification> findAll();
}
