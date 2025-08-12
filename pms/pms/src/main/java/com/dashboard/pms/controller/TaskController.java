package com.dashboard.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dashboard.pms.model.Task;
import com.dashboard.pms.respository.TaskRepository;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        task.setStatus(taskDetails.getStatus());
        task.setHoursLogged(taskDetails.getHoursLogged());
        task.setProject(taskDetails.getProject()); // allow changing project if needed

        return taskRepository.save(task);
    }
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        taskRepository.delete(task);
        return "Task deleted successfully with id: " + id;
    }
    @GetMapping("/status/pending")
    public List<Task> getPendingTasks() {
        return taskRepository.findByStatus("PENDING");
    }
    @GetMapping("/status/completed")
    public List<Task> getCompletedTasks() {
        return taskRepository.findByStatus("COMPLETED");
    }
}
