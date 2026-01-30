package com.example.demo.controller;

import com.example.demo.pojo.dto.CreateTaskRequest;
import com.example.demo.pojo.entity.Student;
import com.example.demo.pojo.entity.Task;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController
{
    private final TaskRepository taskRepository;
    private final StudentRepository studentRepository;

    public TaskController(TaskRepository taskRepository,
                          StudentRepository studentRepository)
    {
        this.taskRepository = taskRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/tasks")
    public List<Task> findAll()
    {
        return taskRepository.findAll();
    }

    @PostMapping("/tasks")
    public Task create(@RequestBody CreateTaskRequest request)
    {
        Student student = studentRepository.findStudentById(request.getStudentId());

        Task task = new Task();
        task.setDescription(request.getDescription());
        task.setCompleted(false);
        task.setStudent(student);

        return taskRepository.save(task);
    }
    @PutMapping("/task/{id}/complete")
    public Task completeTask(@PathVariable Integer id)
    {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null)
        {
            task.setCompleted(true);
            taskRepository.save(task);
        }
        return task;
    }
}
