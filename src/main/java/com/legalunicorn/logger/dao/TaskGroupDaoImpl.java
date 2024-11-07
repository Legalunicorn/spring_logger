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
    public void delete(TaskGroup taskGroup) {
        entityManager.remove(taskGroup);
    }

    @Override
    public TaskGroup findById(int id) {
        return entityManager.find(TaskGroup.class,id);
    }

    @Override
    public void save(TaskGroup taskGroup) {
        entityManager.persist(taskGroup);
    }

    @Override
    public void update(TaskGroup taskGroup) {
        entityManager.merge(taskGroup);
    }
}
