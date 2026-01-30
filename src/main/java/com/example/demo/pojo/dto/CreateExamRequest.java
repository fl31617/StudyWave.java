package com.example.demo.pojo.dto;

import java.time.LocalDate;

public class CreateExamRequest
{
    private String title;
    private LocalDate examDate;
    private Integer studentId;
    private Integer subjectId;

    public CreateExamRequest() {}

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public LocalDate getExamDate()
    {
        return examDate;
    }

    public void setExamDate(LocalDate examDate)
    {
        this.examDate = examDate;
    }

    public Integer getStudentId()
    {
        return studentId;
    }

    public void setStudentId(Integer studentId)
    {
        this.studentId = studentId;
    }

    public Integer getSubjectId()
    {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId)
    {
        this.subjectId = subjectId;
    }
}
