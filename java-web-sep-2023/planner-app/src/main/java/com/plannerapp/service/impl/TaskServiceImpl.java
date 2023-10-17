package com.plannerapp.service.impl;

import com.plannerapp.model.dto.task.TaskAddBindingModel;
import com.plannerapp.model.dto.task.TaskDTO;
import com.plannerapp.model.dto.task.TaskHomeViewModel;
import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.entity.Task;
import com.plannerapp.model.entity.User;
import com.plannerapp.repo.PriorityRepository;
import com.plannerapp.repo.TaskRepository;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final PriorityRepository priorityRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public TaskServiceImpl(TaskRepository taskRepository, PriorityRepository priorityRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.priorityRepository = priorityRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(TaskAddBindingModel taskAddBindingModel) {

        Priority priority = priorityRepository.findByName(taskAddBindingModel.getPriority());

        if(priority != null) {
            Task task = new Task();
            task.setDueDate(taskAddBindingModel.getDueDate());
            task.setDescription(taskAddBindingModel.getDescription());
            task.setPriority(priority);

            taskRepository.save(task);
        }
    }

    @Override
    public void remove(Long id) {

        taskRepository.deleteById(id);
    }

    @Override
    public void assign(Long id, String username) {

        Optional<Task> optionalTask = taskRepository.findById(id);

        if(optionalTask.isPresent()) {
            Task task = optionalTask.get();

            if(username == null) {
                task.setAssignee(null);
            } else {
                User user = userRepository.findByUsername(username);
                task.setAssignee(user);
            }

            taskRepository.save(task);
        }
    }

    @Override
    public TaskHomeViewModel getHomeViewData(String username) {

        User user = userRepository.findByUsername(username);


        List<TaskDTO> assignedTasks = taskRepository
                .findByAssignee(user)
                .stream()
                .map(task -> {
                    TaskDTO taskDTO = new TaskDTO();
                    taskDTO.setId(task.getId());
                    taskDTO.setDescription(task.getDescription());
                    taskDTO.setPriority(task.getPriority().getName());
                    taskDTO.setDueDate(task.getDueDate());

                    return taskDTO;
                }).collect(Collectors.toList());

        List<TaskDTO> allAvailableTasks = taskRepository
                .getAllAvailable()
                .stream()
                .map(task -> {
                    TaskDTO taskDTO = new TaskDTO();
                    taskDTO.setId(task.getId());
                    taskDTO.setDescription(task.getDescription());
                    taskDTO.setPriority(task.getPriority().getName());
                    taskDTO.setDueDate(task.getDueDate());

                    return taskDTO;
                }).collect(Collectors.toList());

        return new TaskHomeViewModel(assignedTasks, allAvailableTasks);
    }
}
