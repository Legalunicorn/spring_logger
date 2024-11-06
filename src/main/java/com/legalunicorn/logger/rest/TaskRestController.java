package com.legalunicorn.logger.rest;


import com.legalunicorn.logger.dto.TaskDTO;
import com.legalunicorn.logger.entity.Task;
import com.legalunicorn.logger.services.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskRestController {

    //Wire the beans
    private final TaskService taskService;
    public TaskRestController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable int taskId){
        Task task = taskService.getTask(taskId);
        return task;
    }

    //create endpoints
    @PostMapping("")
    public Task addTask(@RequestBody TaskDTO taskDTO){
        Task newTask = taskService.createTask(taskDTO);
        return newTask;

    }

    //ADD tasks

}
