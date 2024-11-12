package com.legalunicorn.logger.rest;

import com.legalunicorn.logger.dto.TaskGroupDTO;
import com.legalunicorn.logger.dto.UpdateTaskGroupDTO;
import com.legalunicorn.logger.entity.Task;
import com.legalunicorn.logger.entity.TaskGroup;
import com.legalunicorn.logger.services.TaskGroupService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class TaskGroupRestController {

    private final TaskGroupService taskGroupService;
    public TaskGroupRestController(TaskGroupService taskGroupService){
        this.taskGroupService = taskGroupService;
    }

    @GetMapping("/{groupId}")
    public TaskGroup find(@PathVariable int groupId){
        return taskGroupService.findById(groupId);
    }

    @GetMapping("/{groupId}/tasks")
    public List<Task> findTasksByGroupId(@PathVariable int groupId){
        return taskGroupService.findTasksByGroupId(groupId);
    }

    @GetMapping("")
    public List<TaskGroup> findAll(){
        return taskGroupService.findAll();
    }

    @PostMapping("")
    public TaskGroup postTaskGroup(@Valid @RequestBody TaskGroupDTO taskGroupDTO){
        return taskGroupService.createTaskGroup(taskGroupDTO);
    }

    @PatchMapping("/{groupId}")
    public TaskGroup updateTaskGroup(
            @PathVariable int groupId,
            @RequestBody UpdateTaskGroupDTO updateTaskGroupDTO
            ){
        updateTaskGroupDTO.setId(groupId);
        return taskGroupService.update(updateTaskGroupDTO);
    }

    @DeleteMapping("/{groupId}")
    public void deleteTaskGroup(@PathVariable int groupId){
        taskGroupService.delete(groupId);
    }

}
