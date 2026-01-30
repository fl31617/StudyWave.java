package com.example.demo.controller;

import com.example.demo.pojo.dto.CreateExamRequest;
import com.example.demo.pojo.entity.Exam;
import com.example.demo.pojo.entity.Student;
import com.example.demo.pojo.entity.Subject;
import com.example.demo.repository.ExamRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.SubjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamController
{
    private final ExamRepository examRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public ExamController(ExamRepository examRepository, StudentRepository studentRepository,
                          SubjectRepository subjectRepository)
    {
        this.examRepository = examRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("/exams")
    public List<Exam> findAll()
    {
        return examRepository.findAll();
    }

    @PostMapping("/exams")
    public Exam create(@RequestBody CreateExamRequest request)
    {
        Student student = studentRepository.findStudentById(request.getStudentId());
        Subject subject = subjectRepository.findById(request.getSubjectId()).orElse(null);

        Exam exam = new Exam();
        exam.setTitle(request.getTitle());
        exam.setExamDate(request.getExamDate());
        exam.setStudent(student);
        exam.setSubject(subject);

        return examRepository.save(exam);
    }
}
