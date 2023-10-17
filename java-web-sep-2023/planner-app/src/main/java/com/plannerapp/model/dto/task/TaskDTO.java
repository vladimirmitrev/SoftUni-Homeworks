package com.plannerapp.model.dto.task;

import com.plannerapp.model.entity.enums.PriorityName;

import java.time.LocalDate;

public class TaskDTO {

    private Long id;

    private String description;

    private LocalDate dueDate;

    private PriorityName priority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public PriorityName getPriority() {
        return priority;
    }

    public void setPriority(PriorityName priority) {
        this.priority = priority;
    }
}
