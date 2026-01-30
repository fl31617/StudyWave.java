package com.example.demo.pojo.dto;

public class CreateNotificationRequest
{
    private String message;
    private Integer studentId;
    private Integer examId;

    public CreateNotificationRequest() {}

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Integer getStudentId()
    {
        return studentId;
    }

    public void setStudentId(Integer studentId)
    {
        this.studentId = studentId;
    }

    public Integer getExamId()
    {
        return examId;
    }

    public void setExamId(Integer examId)
    {
        this.examId = examId;
    }
}
