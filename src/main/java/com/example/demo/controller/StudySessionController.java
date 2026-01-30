package com.example.demo.controller;

import com.example.demo.pojo.dto.CreateStudySessionRequest;
import com.example.demo.pojo.entity.Student;
import com.example.demo.pojo.entity.StudySession;
import com.example.demo.pojo.entity.Subject;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.StudySessionRepository;
import com.example.demo.repository.SubjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudySessionController
{
    private final StudySessionRepository studySessionRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public StudySessionController(StudySessionRepository studySessionRepository, StudentRepository studentRepository,
                                  SubjectRepository subjectRepository)
    {
        this.studySessionRepository = studySessionRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("/study-sessions")
    public List<StudySession> findAll()
    {
        return studySessionRepository.findAll();
    }

    @PostMapping("/study-sessions")
    public StudySession create(@RequestBody CreateStudySessionRequest request)
    {
        Student student = studentRepository.findStudentById(request.getStudentId());
        Subject subject = subjectRepository.findById(request.getSubjectId()).orElse(null);

        StudySession session = new StudySession();
        session.setDate(request.getDate());
        session.setDurationMinutes(request.getDurationMinutes());
        session.setStudent(student);
        session.setSubject(subject);

        return studySessionRepository.save(session);
    }
}
