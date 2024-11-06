package com.legalunicorn.logger.services;


import com.legalunicorn.logger.dao.TaskGroupDao;
import com.legalunicorn.logger.dto.TaskGroupDTO;
import com.legalunicorn.logger.entity.TaskGroup;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TaskGroupService {
    private final TaskGroupDao taskGroupDao;
    public TaskGroupService(TaskGroupDao taskGroupDao){
        this.taskGroupDao = taskGroupDao;
    }

    @Transactional
    public TaskGroup createTaskGroup(TaskGroupDTO taskGroupDTO){
        //group
        TaskGroup taskGroup = new TaskGroup();
        if(taskGroupDTO.getColor()!=null){
            taskGroup.setColor(taskGroupDTO.getColor());
        }
        //name
        taskGroup.setName(taskGroupDTO.getName());
        //by default, there are no tasks?
        taskGroupDao.save(taskGroup);
        //the persist method from the Dao will filed in the Id values
        return taskGroup;
    }


}
