package com.example.demo.util;

import com.example.demo.SecurityConfig;
import com.example.demo.model.User;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PreloadDataBasewithData {

    private UserRepository userRepository;
    private TaskRepository taskRepository;
    private SecurityConfig securityConfig;


    public PreloadDataBasewithData(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        securityConfig = new SecurityConfig();
    }

    @Bean
    CommandLineRunner initDatabase() {

        return (args) -> {
            userRepository.deleteAll();
            taskRepository.deleteAll();

            userRepository.save(new User("admin", "admin", securityConfig.encoder().encode("1")));
        };
    }

}
