package com.example.demo.pojo.dto;

public class CreateTaskRequest
{
    private String description;
    private Integer studentId;

    public CreateTaskRequest() {}

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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
