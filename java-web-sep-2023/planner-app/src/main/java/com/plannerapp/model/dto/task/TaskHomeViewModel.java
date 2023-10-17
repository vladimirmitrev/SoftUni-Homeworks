package com.plannerapp.model.dto.task;

import java.util.ArrayList;
import java.util.List;

public class TaskHomeViewModel {

    private List<TaskDTO> tasksAssignedToMe;
    private List<TaskDTO> allTasks;

    public TaskHomeViewModel() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    public TaskHomeViewModel(List<TaskDTO> tasksAssignedToMe, List<TaskDTO> allTasks) {
        this.tasksAssignedToMe = tasksAssignedToMe;
        this.allTasks = allTasks;
    }

    public List<TaskDTO> getTasksAssignedToMe() {
        return tasksAssignedToMe;
    }

    public List<TaskDTO> getAllTasks() {
        return allTasks;
    }
}
