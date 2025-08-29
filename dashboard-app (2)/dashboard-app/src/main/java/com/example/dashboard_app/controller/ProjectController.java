package com.example.dashboard_app.controller;

import com.example.dashboard_app.model.Employee;
import com.example.dashboard_app.model.Project;
import com.example.dashboard_app.service.EmployeeService;
import com.example.dashboard_app.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {

    private final ProjectService projectService;
    private final EmployeeService employeeService;

    public ProjectController(ProjectService projectService, EmployeeService employeeService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        Set<Employee> resolvedMembers = resolveMembers(project.getMembers());
        project.setMembers(resolvedMembers);
        return projectService.saveProject(project);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project updatedProject) {
        return projectService.getProjectById(id).map(project -> {
            project.setProjectName(updatedProject.getProjectName());
            project.setDeadline(updatedProject.getDeadline());
            project.setClient(updatedProject.getClient());
            project.setStatus(updatedProject.getStatus());
            project.setCompletionPercentage(updatedProject.getCompletionPercentage());
            project.setMembers(resolveMembers(updatedProject.getMembers()));
            return ResponseEntity.ok(projectService.saveProject(project));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    private Set<Employee> resolveMembers(Set<Employee> incomingMembers) {
        Set<Employee> resolved = new HashSet<>();
        for (Employee e : incomingMembers) {
            employeeService.getEmployeeById(e.getId()).ifPresent(resolved::add);
        }
        return resolved;
    }
}
