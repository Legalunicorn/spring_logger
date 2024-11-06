package com.legalunicorn.logger.dao;

import com.legalunicorn.logger.entity.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskDao {

    //=======READ========

    //get a task by id
    Task findById(int taskId);

    //get all tasks
    List<Task> findAllOrderByDate();

    //get a task from group
    List<Task> findByGroupId(int groupId);

    //get a task from a date
    List<Task> findByDate(LocalDate date);


    //======= CREATE ========
    //save task into the db
    Task save(Task task);


    //======= UPDATE ========
    Task update(Task task);

    //======== delete ========
    Task deleteById(int taskId);







}
