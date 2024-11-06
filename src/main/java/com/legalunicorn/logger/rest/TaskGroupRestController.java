package com.legalunicorn.logger.rest;

import com.legalunicorn.logger.dto.TaskGroupDTO;
import com.legalunicorn.logger.entity.TaskGroup;
import com.legalunicorn.logger.services.TaskGroupService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groups")
public class TaskGroupRestController {

    private final TaskGroupService taskGroupService;
    public TaskGroupRestController(TaskGroupService taskGroupService){
        this.taskGroupService = taskGroupService;
    }

    @PostMapping("")
    public TaskGroup postTaskGroup(@RequestBody TaskGroupDTO taskGroupDTO){
        return taskGroupService.createTaskGroup(taskGroupDTO);
    }

}
