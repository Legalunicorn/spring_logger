package com.legalunicorn.logger.dto;

import com.legalunicorn.logger.entity.Task;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class TaskGroupDTO {

    @NotNull
    private String name;
    private String color;
    private List<Task> tasks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
