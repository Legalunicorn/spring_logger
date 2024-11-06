package com.legalunicorn.logger.dao;


import com.legalunicorn.logger.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {

    private final EntityManager entityManager;

    public TaskDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public Task findById(int taskId) {
        return entityManager.find(Task.class,taskId);
    }

    @Override
    public List<Task> findAllOrderByDate() {
        //query
        TypedQuery<Task> query = entityManager.createQuery("from Task order by dateCompleted asc",Task.class);
        return query.getResultList();
    }

    @Override
    public List<Task> findByGroupId(int groupId) {
        TypedQuery<Task> query = entityManager.createQuery("from Task where task_group_id=:groupId",Task.class);
        query.setParameter("groupId",groupId);
        return query.getResultList();
    }

    @Override
    public List<Task> findByDate(LocalDate date) {
        TypedQuery<Task> query = entityManager.createQuery("from Task where dateCompleted=:myDate",Task.class);
        query.setParameter("myDate",date);
        return query.getResultList();
    }

    @Override
    public Task save(Task task) {
        Task dbTask = entityManager.merge(task);
        return dbTask;

    }

    @Override
    public Task update(Task task) {
        entityManager.merge(task);
        return task;
    }

    @Override
    public Task deleteById(int taskId) {
        Task task = entityManager.find(Task.class,taskId);
        // remove student and return it
        entityManager.remove(task);
        return task;

    }
}
