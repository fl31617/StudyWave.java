package com.example.demo.pojo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "student")
    private List<Subject> subjects;

    @OneToMany(mappedBy = "student")
    private List<Task> tasks;

    @OneToMany(mappedBy = "student")
    private List<StudySession> studySessions;

    @OneToMany(mappedBy = "student")
    private List<Notification> notifications;

    // getters & setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
