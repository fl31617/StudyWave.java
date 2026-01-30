package com.example.demo.service;

import com.example.demo.pojo.dto.CreateExamRequest;
import com.example.demo.pojo.entity.Exam;

import java.util.List;

public interface ExamService
{
    Exam create(CreateExamRequest request);

    List<Exam> getAll();
}
