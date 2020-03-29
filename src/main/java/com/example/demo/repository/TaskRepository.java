package com.example.demo.repository;

import com.example.demo.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {

    Page<Task> findAllByUserEmail(String userEmail, Pageable pageable);
}
