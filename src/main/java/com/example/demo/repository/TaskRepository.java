package com.example.demo.repository;

import com.example.demo.pojo.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer>
{
    List<Task> findAll();
}
