package com.legalunicorn.logger.dao;


import com.legalunicorn.logger.entity.TaskGroup;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class TaskGroupDaoImpl implements TaskGroupDao {

    private final EntityManager entityManager;

    public TaskGroupDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public TaskGroup findById(int id) {
        return entityManager.find(TaskGroup.class,id);
    }
}
