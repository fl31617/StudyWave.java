package com.example.demo.service;

import com.example.demo.pojo.dto.CreateStudySessionRequest;
import com.example.demo.pojo.entity.StudySession;

import java.util.List;

public interface StudySessionService
{
    StudySession create(CreateStudySessionRequest request);

    List<StudySession> getAll();
}
