package com.example.demo.service;

import com.example.demo.pojo.dto.CreateSubjectRequest;
import com.example.demo.pojo.entity.Student;
import com.example.demo.pojo.entity.Subject;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultSubjectService implements SubjectService
{
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

    public DefaultSubjectService(SubjectRepository subjectRepository, StudentRepository studentRepository)
    {
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Subject create(CreateSubjectRequest request)
    {
        Student student = studentRepository.findById(request.getStudentId()).orElse(null);

        Subject subject = new Subject();
        subject.setName(request.getName());
        subject.setStudent(student);

        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> getAll()
    {
        return subjectRepository.findAll();
    }
}
