package com.example.demo.service;

import com.example.demo.dto.AddTaskDto;
import com.example.demo.dto.ResponseTaskDto;
import com.example.demo.model.Status;
import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public Page<ResponseTaskDto> getAllTasksForUser(Authentication authentication, Pageable pageable) {
        var user = (User) authentication.getPrincipal();
        var slice = taskRepository.findAllByUserEmail(user.getEmail(), pageable);

        return slice.map(ResponseTaskDto::from);
    }
}
