package com.example.project.service;

import com.example.project.model.Task;
import com.example.project.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setName(taskDetails.getName());
            task.setDescription(taskDetails.getDescription());
            task.setDuration(taskDetails.getDuration());
            task.setStartTime(taskDetails.getStartTime());
            task.setEndTime(taskDetails.getEndTime());
            task.setComplete(taskDetails.isComplete());
            task.setPath(taskDetails.getPath());
            task.setParentTask(taskDetails.getParentTask());
            task.setProject(taskDetails.getProject());
            return taskRepository.save(task);
        } else {
            return null;
        }
    }

    public boolean deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            taskRepository.delete(task);
            return true;
        } else {
            return false;
        }
    }
}
