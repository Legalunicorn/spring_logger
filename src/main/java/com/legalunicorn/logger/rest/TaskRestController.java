package com.legalunicorn.logger.rest;


import com.legalunicorn.logger.dto.TaskDTO;
import com.legalunicorn.logger.dto.UpdateTaskDTO;
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

    @GetMapping("/date/{date_completed}")
    public List<Task> searchTasksByDate(
            @PathVariable
            @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) LocalDate date_completed
            ){
        if (date_completed!=null){
            return taskService.getTasksByDate(date_completed);
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

    @PatchMapping("/{taskId}")
    public Task updateTask(
            @PathVariable int taskId,
            @RequestBody UpdateTaskDTO updateTaskDTO)
    {
        updateTaskDTO.setId(taskId);
        return taskService.update(updateTaskDTO);
    }

    //ADD tasks

}
