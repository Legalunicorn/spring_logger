package com.legalunicorn.logger.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class TaskDTO {
    //POJO
    private String description;

    @JsonProperty("date_completed")
    private LocalDate dateCompleted;
    private Integer groupId;



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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String toString() {
        return "TaskDTO{" +
                "description='" + description + '\'' +
                ", dateCompleted=" + dateCompleted +
                ", groupId=" + groupId +
                '}';
    }
}
