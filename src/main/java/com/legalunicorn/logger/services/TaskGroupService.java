package com.legalunicorn.logger.services;


import com.legalunicorn.logger.dao.TaskDao;
import com.legalunicorn.logger.dao.TaskGroupDao;
import com.legalunicorn.logger.dto.TaskGroupDTO;
import com.legalunicorn.logger.dto.UpdateTaskGroupDTO;
import com.legalunicorn.logger.entity.Task;
import com.legalunicorn.logger.entity.TaskGroup;
import com.legalunicorn.logger.exceptions.TaskGroupNotFoundException;
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

    public List<TaskGroup> findAll(){
        return taskGroupDao.findAll();
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
        //the persist method from the Dao will fill in the ID values
        return taskGroup;
    }

    @Transactional
    public TaskGroup update(UpdateTaskGroupDTO updateTaskGroupDTO){
        TaskGroup taskGroup = taskGroupDao.findById(updateTaskGroupDTO.getId());
        String newName = updateTaskGroupDTO.getName();
        String newColor = updateTaskGroupDTO.getColor();
        if (newName!=null){
            taskGroup.setName(newName);
        }
        if (newColor!=null){
            taskGroup.setColor(newColor);
        }
        taskGroupDao.update(taskGroup);
        return taskGroup;
    }

    // == DELETE ==
    @Transactional
    public void delete(int groupId){
        //find first
        TaskGroup deletingGroup = taskGroupDao.findById(groupId);
        if (deletingGroup==null){
            throw new TaskGroupNotFoundException();
        }
        //task dao update where groupId = x
        taskDao.detachFromGroupById(groupId);
        //task group dao to delete
        taskGroupDao.delete(deletingGroup);

        //
    }


}
