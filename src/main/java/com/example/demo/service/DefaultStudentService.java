package com.example.demo.service;

import com.example.demo.pojo.dto.CreateStudentRequest;
import com.example.demo.pojo.dto.UpdateStudentRequest;
import com.example.demo.pojo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultStudentService implements StudentService
{
    private final StudentRepository studentRepository;

    public DefaultStudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(CreateStudentRequest request)
    {
        Student student = new Student();
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        return studentRepository.save(student);
    }

    @Override
    public Student update(Integer id, UpdateStudentRequest request)
    {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null)
        {
            student.setEmail(request.getEmail());
            return studentRepository.save(student);
        }
        return null;
    }
    @Override
    public List<Student> getAll()
    {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(Integer id)
    {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id)
    {
        studentRepository.deleteById(id);
    }
}
