package com.example.demo.dto;

import com.example.demo.model.Status;
import com.example.demo.model.Task;

import java.time.LocalDate;

public class ResponseTaskDto {

    private String id;
    private String name;
    private String status;
    private String date; //на какую дату запланированно

    public ResponseTaskDto(String id, String name, String status, String date) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.date = date;
    }

    public static ResponseTaskDto from(Task task) {
        return new ResponseTaskDto(task.getId(), task.getName(), task.getStatus().toString(), task.getDate());
    }

    public ResponseTaskDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
