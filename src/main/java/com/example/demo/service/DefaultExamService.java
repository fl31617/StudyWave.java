package com.example.demo.service;

import com.example.demo.pojo.dto.CreateExamRequest;
import com.example.demo.pojo.entity.Exam;
import com.example.demo.pojo.entity.Student;
import com.example.demo.pojo.entity.Subject;
import com.example.demo.repository.ExamRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultExamService implements ExamService
{
    private final ExamRepository examRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public DefaultExamService(ExamRepository examRepository, StudentRepository studentRepository,
                              SubjectRepository subjectRepository)
    {
        this.examRepository = examRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Exam create(CreateExamRequest request)
    {
        Student student = studentRepository.findById(request.getStudentId()).orElse(null);
        Subject subject = subjectRepository.findById(request.getSubjectId()).orElse(null);

        Exam exam = new Exam();
        exam.setTitle(request.getTitle());
        exam.setExamDate(request.getExamDate());
        exam.setStudent(student);
        exam.setSubject(subject);

        return examRepository.save(exam);
    }

    @Override
    public List<Exam> getAll()
    {
        return examRepository.findAll();
    }
}
