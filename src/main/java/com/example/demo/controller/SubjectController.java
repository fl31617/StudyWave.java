package com.example.demo.controller;

import com.example.demo.pojo.dto.CreateSubjectRequest;
import com.example.demo.pojo.entity.Student;
import com.example.demo.pojo.entity.Subject;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.SubjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController
{
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

    public SubjectController(SubjectRepository subjectRepository, StudentRepository studentRepository)
    {
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/subjects")
    public List<Subject> findAll()
    {
        return subjectRepository.findAll();
    }

    @PostMapping("/subjects")
    public Subject create(@RequestBody CreateSubjectRequest request)
    {
        Student student = studentRepository.findStudentById(request.getStudentId());

        Subject subject = new Subject();
        subject.setName(request.getName());
        subject.setStudent(student);

        return subjectRepository.save(subject);
    }
}
