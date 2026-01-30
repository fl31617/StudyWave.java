package com.example.demo.service;

import com.example.demo.pojo.dto.CreateTaskRequest;
import com.example.demo.pojo.entity.Student;
import com.example.demo.pojo.entity.Task;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultTaskService implements TaskService
{
    private final TaskRepository taskRepository;
    private final StudentRepository studentRepository;

    public DefaultTaskService(TaskRepository taskRepository, StudentRepository studentRepository)
    {
        this.taskRepository = taskRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Task create(CreateTaskRequest request)
    {
        Student student = studentRepository.findById(request.getStudentId()).orElse(null);

        Task task = new Task();
        task.setDescription(request.getDescription());
        task.setCompleted(false);
        task.setStudent(student);

        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAll()
    {
        return taskRepository.findAll();
    }
}
