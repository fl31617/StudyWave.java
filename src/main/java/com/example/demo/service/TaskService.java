package com.example.demo.service;

import com.example.demo.pojo.dto.CreateTaskRequest;
import com.example.demo.pojo.entity.Task;

import java.util.List;

public interface TaskService
{
    Task create(CreateTaskRequest request);

    List<Task> getAll();
}
