package com.legalunicorn.logger.dao;


import com.legalunicorn.logger.entity.TaskGroup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<TaskGroup> findAll() {
        TypedQuery<TaskGroup> query = entityManager.createQuery("from TaskGroup",TaskGroup.class);
        return query.getResultList();
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
