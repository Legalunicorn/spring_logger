package com.legalunicorn.logger.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;

public class UpdateTaskDTO {

    private int id;

    @JsonProperty("date_completed")
    private LocalDate dateCompleted;

//    @NotNull(message ="Group Id is required for updating Task")
    @Min(value=1, message="Group ID cannot be absent or less than 1")
    @JsonProperty("group_id")
    private Integer groupId; //nullable

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
