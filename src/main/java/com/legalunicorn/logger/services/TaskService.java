package com.legalunicorn.logger.services;


import com.legalunicorn.logger.dao.TaskDao;
import com.legalunicorn.logger.dao.TaskGroupDao;
import com.legalunicorn.logger.dto.TaskDTO;
import com.legalunicorn.logger.dto.UpdateTaskDTO;
import com.legalunicorn.logger.entity.Task;
import com.legalunicorn.logger.entity.TaskGroup;
import com.legalunicorn.logger.exceptions.TaskGroupNotFoundException;
import com.legalunicorn.logger.exceptions.TaskNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    //wire beans
    private final TaskDao taskDao;
    private final TaskGroupDao taskGroupDao;
    public TaskService(TaskDao taskDao, TaskGroupDao taskGroupDao){
        this.taskDao = taskDao;
        this.taskGroupDao = taskGroupDao;
    }

    //create services

    //CREATE USER
    @Transactional
    public Task createTask(TaskDTO taskDTO){
        Task task = new Task(); //To return this
        task.setDescription(taskDTO.getDescription());
        task.setDateCompleted(taskDTO.getDateCompleted());
        //Check if DTO has an ID
        if (taskDTO.getGroupId()!=null){
            TaskGroup taskGroup = taskGroupDao.findById(taskDTO.getGroupId());
            if (taskGroup==null){
                throw new RuntimeException("TaskGroup not found: "+taskDTO.getGroupId());
            }
            task.setTaskGroup(taskGroup);
        }
        return taskDao.save(task);
    }

    public Task getTask(int taskId){
        Task task = taskDao.findById(taskId);
        if (task==null){
            throw new TaskNotFoundException();
        }
        return task;
    }

    public List<Task> getAllTaskOrderByDate(){
        return taskDao.findAllOrderByDate();
    }

    public List<Task> getTasksByDate(LocalDate date){
        return taskDao.findByDate(date);
    }

    public List<Task> getTaskByGroupId(int groupId){
        return taskDao.findByGroupId(groupId);
    }

    // =============== PATCH ==============
    @Transactional
    public Task update(UpdateTaskDTO updateTaskDTO){
        //Find the task by ID
        Task updatedTask = taskDao.findById(updateTaskDTO.getId());

        //Set optional field
        if (updateTaskDTO.getDateCompleted()!=null){
            updatedTask.setDateCompleted(updateTaskDTO.getDateCompleted());
        }
        if (updateTaskDTO.getDescription()!=null){
            updatedTask.setDescription(updateTaskDTO.getDescription());
        }
        if (updateTaskDTO.getGroupId()!=null){
            TaskGroup tempGroup = taskGroupDao.findById(updateTaskDTO.getGroupId());
            if (tempGroup==null){
                throw new TaskGroupNotFoundException();
            }
            updatedTask.setTaskGroup(tempGroup);
        }

        //DAO update
        taskDao.update(updatedTask);

        //return the new task
        return updatedTask;

    }

}
