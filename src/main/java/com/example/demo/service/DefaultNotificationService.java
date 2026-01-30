package com.example.demo.service;

import com.example.demo.pojo.dto.CreateNotificationRequest;
import com.example.demo.pojo.entity.Exam;
import com.example.demo.pojo.entity.Notification;
import com.example.demo.pojo.entity.Student;
import com.example.demo.repository.ExamRepository;
import com.example.demo.repository.NotificationRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultNotificationService implements NotificationService
{
    private final NotificationRepository notificationRepository;
    private final StudentRepository studentRepository;
    private final ExamRepository examRepository;

    public DefaultNotificationService(NotificationRepository notificationRepository, StudentRepository studentRepository,
                                      ExamRepository examRepository)
    {
        this.notificationRepository = notificationRepository;
        this.studentRepository = studentRepository;
        this.examRepository = examRepository;
    }

    @Override
    public Notification create(CreateNotificationRequest request)
    {
        Student student = studentRepository.findById(request.getStudentId()).orElse(null);
        Exam exam = request.getExamId() != null ? examRepository.findById(request.getExamId()).orElse(null) : null;

        Notification notification = new Notification();
        notification.setMessage(request.getMessage());
        notification.setSeen(false);
        notification.setStudent(student);
        notification.setExam(exam);

        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }
}
