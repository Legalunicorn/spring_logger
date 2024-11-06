package com.legalunicorn.logger.rest;


import com.legalunicorn.logger.dto.TaskDTO;
import com.legalunicorn.logger.entity.Task;
import com.legalunicorn.logger.services.TaskService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskRestController {

    //Wire the beans
    private final TaskService taskService;
    public TaskRestController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/search")
    public List<Task> searchTasksByDate(
            @RequestParam(value="date_completed",required = false)
            @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate dateCompleted,
            @RequestParam(value="group_id",required = false) Integer groupId
            ){


        if (dateCompleted!=null){
            return taskService.getTasksByDate(dateCompleted);
        }
        if (groupId!=null){
            System.out.println("return by group here");
        }

        throw new IllegalArgumentException("Either search task by date or group id");

    }

    @GetMapping("")
    public List<Task> getAllTasksOrderByDate(){
        return taskService.getAllTaskOrderByDate();
    }

    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable int taskId){
        return taskService.getTask(taskId);
    }

    //create endpoints
    @PostMapping("")
    public Task addTask(@RequestBody TaskDTO taskDTO){
        return taskService.createTask(taskDTO);

    }

    //ADD tasks

}
