package com.legalunicorn.logger.services;


import com.legalunicorn.logger.dao.TaskDao;
import com.legalunicorn.logger.dao.TaskGroupDao;
import com.legalunicorn.logger.dto.TaskGroupDTO;
import com.legalunicorn.logger.entity.Task;
import com.legalunicorn.logger.entity.TaskGroup;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskGroupService {
    private final TaskGroupDao taskGroupDao;
    private final TaskDao taskDao;
    public TaskGroupService(TaskGroupDao taskGroupDao,TaskDao taskDao){
        this.taskGroupDao = taskGroupDao;
        this.taskDao = taskDao;
    }


    // ===========  GET =============
    public TaskGroup findById(int groupId){
        return taskGroupDao.findById(groupId);
    }
    public List<Task> findTasksByGroupId(int groupId){
        return taskDao.findByGroupId(groupId);
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
