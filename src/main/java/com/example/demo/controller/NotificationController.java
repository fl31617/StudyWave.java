package com.example.demo.controller;

import com.example.demo.pojo.dto.CreateNotificationRequest;
import com.example.demo.pojo.entity.Exam;
import com.example.demo.pojo.entity.Notification;
import com.example.demo.pojo.entity.Student;
import com.example.demo.repository.ExamRepository;
import com.example.demo.repository.NotificationRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {

    private final NotificationRepository notificationRepository;
    private final StudentRepository studentRepository;
    private final ExamRepository examRepository;

    public NotificationController(NotificationRepository notificationRepository, StudentRepository studentRepository,
                                  ExamRepository examRepository)
    {
        this.notificationRepository = notificationRepository;
        this.studentRepository = studentRepository;
        this.examRepository = examRepository;
    }

    @GetMapping("/notifications")
    public List<Notification> findAll()
    {
        return notificationRepository.findAll();
    }

    @PostMapping("/notifications")
    public Notification create(@RequestBody CreateNotificationRequest request)
    {
        Student student = studentRepository.findStudentById(request.getStudentId());
        Exam exam = request.getExamId() != null ? examRepository.findById(request.getExamId()).orElse(null) : null;

        Notification notification = new Notification();
        notification.setMessage(request.getMessage());
        notification.setSeen(false);
        notification.setStudent(student);
        notification.setExam(exam);

        return notificationRepository.save(notification);
    }
    @PutMapping("/notification/{id}/seen")
    public Notification markAsSeen(@PathVariable Integer id)
    {
        Notification notification = notificationRepository.findById(id).orElse(null);
        if (notification != null)
        {
            notification.setSeen(true);
            notificationRepository.save(notification);
        }
        return notification;
    }
}
