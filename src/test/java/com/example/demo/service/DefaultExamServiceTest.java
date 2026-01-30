package com.example.demo.service;

import com.example.demo.pojo.dto.CreateExamRequest;
import com.example.demo.pojo.entity.Exam;
import com.example.demo.pojo.entity.Student;
import com.example.demo.pojo.entity.Subject;
import com.example.demo.repository.ExamRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.SubjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DefaultExamServiceTest {

    private ExamRepository examRepository;
    private StudentRepository studentRepository;
    private SubjectRepository subjectRepository;
    private DefaultExamService examService;

    @BeforeEach
    void setUp() {
        examRepository = mock(ExamRepository.class);
        studentRepository = mock(StudentRepository.class);
        subjectRepository = mock(SubjectRepository.class);

        examService = new DefaultExamService(
                examRepository,
                studentRepository,
                subjectRepository
        );
    }

    @Test
    void createExam() {
        Student student = new Student();
        student.setId(1);

        Subject subject = new Subject();
        subject.setId(2);

        when(studentRepository.findById(1))
                .thenReturn(Optional.of(student));

        when(subjectRepository.findById(2))
                .thenReturn(Optional.of(subject));

        when(examRepository.save(any(Exam.class)))
                .thenAnswer(i -> i.getArgument(0));

        CreateExamRequest request = new CreateExamRequest();
        request.setTitle("Math Exam");
        request.setExamDate(LocalDate.of(2026, 2, 10));
        request.setStudentId(1);
        request.setSubjectId(2);

        Exam exam = examService.create(request);

        assertNotNull(exam);
        assertEquals("Math Exam", exam.getTitle());
        assertEquals(student, exam.getStudent());
        assertEquals(subject, exam.getSubject());
    }

    @Test
    void getAllExams() {
        when(examRepository.findAll())
                .thenReturn(List.of(new Exam(), new Exam()));

        assertEquals(2, examService.getAll().size());
    }
}
