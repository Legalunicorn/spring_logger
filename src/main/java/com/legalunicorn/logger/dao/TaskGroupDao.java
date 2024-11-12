package com.legalunicorn.logger.dao;

import com.legalunicorn.logger.entity.TaskGroup;

import java.util.List;

public interface TaskGroupDao {

    TaskGroup findById(int id);

    void save(TaskGroup taskGroup);

    void update(TaskGroup taskGroup);

    void delete(TaskGroup taskGroup);

    List<TaskGroup> findAll();

}
