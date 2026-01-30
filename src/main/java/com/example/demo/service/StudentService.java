package com.example.demo.service;

import com.example.demo.pojo.dto.CreateStudentRequest;
import com.example.demo.pojo.dto.UpdateStudentRequest;
import com.example.demo.pojo.entity.Student;

import java.util.List;

public interface StudentService
{
    Student create(CreateStudentRequest request);

    Student update(Integer id, UpdateStudentRequest request);

    List<Student> getAll();

    Student getById(Integer id);

    void delete(Integer id);
}
