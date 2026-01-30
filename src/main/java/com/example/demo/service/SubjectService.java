package com.example.demo.service;

import com.example.demo.pojo.dto.CreateSubjectRequest;
import com.example.demo.pojo.entity.Subject;

import java.util.List;

public interface SubjectService
{
    Subject create(CreateSubjectRequest request);

    List<Subject> getAll();
}
