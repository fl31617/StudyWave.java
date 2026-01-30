package com.example.demo.service;

import com.example.demo.pojo.dto.CreateNotificationRequest;
import com.example.demo.pojo.entity.Exam;
import com.example.demo.pojo.entity.Notification;
import com.example.demo.pojo.entity.Student;
import com.example.demo.repository.ExamRepository;
import com.example.demo.repository.NotificationRepository;
import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DefaultNotificationServiceTest {

    private NotificationRepository notificationRepository;
    private StudentRepository studentRepository;
    private ExamRepository examRepository;
    private DefaultNotificationService notificationService;

    @BeforeEach
    void setUp() {
        notificationRepository = mock(NotificationRepository.class);
        studentRepository = mock(StudentRepository.class);
        examRepository = mock(ExamRepository.class);

        notificationService = new DefaultNotificationService(
                notificationRepository,
                studentRepository,
                examRepository
        );
    }

    @Test
    void createNotification() {
        Student student = new Student();
        student.setId(1);

        Exam exam = new Exam();
        exam.setId(2);

        when(studentRepository.findById(1))
                .thenReturn(Optional.of(student));

        when(examRepository.findById(2))
                .thenReturn(Optional.of(exam));

        when(notificationRepository.save(any(Notification.class)))
                .thenAnswer(i -> i.getArgument(0));

        CreateNotificationRequest request = new CreateNotificationRequest();
        request.setMessage("Exam soon");
        request.setStudentId(1);
        request.setExamId(2);

        Notification notification = notificationService.create(request);

        assertNotNull(notification);
        assertFalse(notification.isSeen());
        assertEquals("Exam soon", notification.getMessage());
    }

    @Test
    void getAllNotifications() {
        when(notificationRepository.findAll())
                .thenReturn(List.of(new Notification(), new Notification()));

        assertEquals(2, notificationService.getAll().size());
    }
}
