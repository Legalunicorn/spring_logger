package com.legalunicorn.logger.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="description")
    private String description ;

    @Column(name="date_completed")
    private LocalDate dateCompleted;


    @ManyToOne(
//            fetch = FetchType.LAZY,
            cascade= {CascadeType.DETACH,CascadeType.PERSIST,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="task_group_id")
//    @JsonIgnore
    private TaskGroup taskGroup;


    //no args constructor
    public Task(){
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getDateCompleted() {
        return dateCompleted;
    }
    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }
    public TaskGroup getTaskGroup() {
        return taskGroup;
    }
    public void setTaskGroup(TaskGroup taskGroup) {
        this.taskGroup = taskGroup;
    }
}
