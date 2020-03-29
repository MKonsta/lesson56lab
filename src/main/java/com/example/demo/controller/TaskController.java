package com.example.demo.controller;

import com.example.demo.dto.AddTaskDto;
import com.example.demo.dto.ResponseTaskDto;
import com.example.demo.model.User;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseTaskDto addTask(@RequestBody AddTaskDto addTaskDto, Authentication authentication) {
        return taskService.addTask(addTaskDto, (User) authentication.getPrincipal());
    }
}
