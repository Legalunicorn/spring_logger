package com.legalunicorn.logger.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="task_group")
public class TaskGroup {
    /*
    ========= Columns and Mapping =============
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="color")
    private String color;

    @OneToMany(mappedBy="taskGroup",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
    )
    private List<Task> tasks;

    //No args constructor
    public TaskGroup(){

    }


    //Convenience method(?)
    public void add(Task task){
        if (tasks==null){
            tasks = new ArrayList<>();
        }
        tasks.add(task); //Add new task
    }

    /*
    ======= Getters and Setters ============
     */

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
