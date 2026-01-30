package com.example.demo.pojo.dto;

public class CreateStudentRequest
{
    private String name;
    private String email;

    public CreateStudentRequest() {}

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
