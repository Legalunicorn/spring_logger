package com.legalunicorn.logger.dao;

import com.legalunicorn.logger.entity.TaskGroup;

public interface TaskGroupDao {

    TaskGroup findById(int id);

    void save(TaskGroup taskGroup);
}
