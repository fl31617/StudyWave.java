package com.example.demo.controller;

import com.example.demo.pojo.dto.CreateStudentRequest;
import com.example.demo.pojo.dto.UpdateStudentRequest;
import com.example.demo.pojo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController
{
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello StudyWave!";
    }

    @GetMapping("/students")
    public List<Student> findAll()
    {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public Student findById(@PathVariable Integer id)
    {
        return studentRepository.findStudentById(id);
    }

    @PostMapping("/students")
    public Student create(@RequestBody CreateStudentRequest request)
    {
        Student student = new Student();
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        return studentRepository.save(student);
    }

    @PutMapping("/student/{id}")
    public Student update(@PathVariable Integer id, @RequestBody UpdateStudentRequest request)
    {
        Student student = studentRepository.findStudentById(id);
        if (student != null)
        {
            student.setEmail(request.getEmail());
            studentRepository.save(student);
        }
        return student;
    }

    @DeleteMapping("/student/{id}")
    public void delete(@PathVariable Integer id)
    {
        studentRepository.deleteById(id);
    }
}
