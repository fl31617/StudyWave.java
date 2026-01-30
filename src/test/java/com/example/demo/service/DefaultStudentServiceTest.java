package com.example.demo.service;

import com.example.demo.pojo.dto.CreateStudentRequest;
import com.example.demo.pojo.dto.UpdateStudentRequest;
import com.example.demo.pojo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DefaultStudentServiceTest {

    private StudentRepository studentRepository;
    private DefaultStudentService studentService;

    @BeforeEach
    void setUp() {
        studentRepository = mock(StudentRepository.class);
        studentService = new DefaultStudentService(studentRepository);
    }

    @Test
    void createStudent() {
        CreateStudentRequest request = new CreateStudentRequest();
        request.setName("Ardit");
        request.setEmail("ardit@gmail.com");

        Student student = new Student();
        student.setName("Ardit");
        student.setEmail("ardit@gmail.com");

        when(studentRepository.save(any(Student.class)))
                .thenReturn(student);

        Student result = studentService.create(request);

        assertNotNull(result);
        assertEquals("Ardit", result.getName());
        assertEquals("ardit@gmail.com", result.getEmail());
    }

    @Test
    void updateStudent() {
        Student student = new Student();
        student.setId(1);

        when(studentRepository.findById(1))
                .thenReturn(Optional.of(student));

        when(studentRepository.save(any(Student.class)))
                .thenReturn(student);

        UpdateStudentRequest request = new UpdateStudentRequest();
        request.setEmail("new@gmail.com");

        Student updated = studentService.update(1, request);

        assertNotNull(updated);
        assertEquals("new@gmail.com", updated.getEmail());
    }

    @Test
    void updateStudentNotFound() {
        when(studentRepository.findById(10))
                .thenReturn(Optional.empty());

        UpdateStudentRequest request = new UpdateStudentRequest();
        request.setEmail("test@gmail.com");

        Student result = studentService.update(10, request);

        assertNull(result);
    }
}
