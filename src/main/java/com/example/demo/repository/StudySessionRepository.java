package com.example.demo.repository;

import com.example.demo.pojo.entity.StudySession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudySessionRepository
        extends CrudRepository<StudySession, Integer>
{
    List<StudySession> findAll();
}
