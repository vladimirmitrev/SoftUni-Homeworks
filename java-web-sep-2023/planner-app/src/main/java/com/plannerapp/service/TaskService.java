package com.plannerapp.service;

import com.plannerapp.model.dto.task.TaskAddBindingModel;
import com.plannerapp.model.dto.task.TaskHomeViewModel;

public interface TaskService {

    void add(TaskAddBindingModel taskAddBindingModel);

    void remove(Long id);

    void assign(Long id, String username);

    TaskHomeViewModel getHomeViewData(String username);
}
