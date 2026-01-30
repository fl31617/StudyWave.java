package com.example.demo.pojo.dto;

public class CreateSubjectRequest
{
    private String name;
    private Integer studentId;

    public CreateSubjectRequest() {}

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getStudentId()
    {
        return studentId;
    }

    public void setStudentId(Integer studentId)
    {
        this.studentId = studentId;
    }
}
