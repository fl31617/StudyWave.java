package com.example.demo.service;

import com.example.demo.pojo.dto.CreateStudySessionRequest;
import com.example.demo.pojo.entity.Student;
import com.example.demo.pojo.entity.StudySession;
import com.example.demo.pojo.entity.Subject;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.StudySessionRepository;
import com.example.demo.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultStudySessionService implements StudySessionService
{
    private final StudySessionRepository studySessionRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public DefaultStudySessionService(StudySessionRepository studySessionRepository, StudentRepository studentRepository,
                                      SubjectRepository subjectRepository)
    {
        this.studySessionRepository = studySessionRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public StudySession create(CreateStudySessionRequest request)
    {
        Student student = studentRepository.findById(request.getStudentId()).orElse(null);
        Subject subject = subjectRepository.findById(request.getSubjectId()).orElse(null);

        StudySession session = new StudySession();
        session.setDate(request.getDate());
        session.setDurationMinutes(request.getDurationMinutes());
        session.setStudent(student);
        session.setSubject(subject);

        return studySessionRepository.save(session);
    }

    @Override
    public List<StudySession> getAll() {
        return studySessionRepository.findAll();
    }
}
