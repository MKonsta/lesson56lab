package com.example.demo.service;

import com.example.demo.dto.AddTaskDto;
import com.example.demo.dto.ResponseTaskDto;
import com.example.demo.model.Status;
import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public ResponseTaskDto addTask(AddTaskDto addTaskDto, User user) {
        Task task = taskRepository.save(new Task(addTaskDto.getName(), addTaskDto.getDescription(), addTaskDto.getDate(), user.getEmail(), Status.NEW));
        return new ResponseTaskDto(task.getId(), task.getName(), task.getStatus().toString(), task.getDate());
    }
}
