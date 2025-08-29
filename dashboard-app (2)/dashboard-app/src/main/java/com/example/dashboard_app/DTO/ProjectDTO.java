package com.example.dashboard_app.DTO;
import com.example.dashboard_app.model.Project;
import com.example.dashboard_app.model.Employee;
import com.example.dashboard_app.model.ProjectStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectDTO {

    private Long id;
    private String projectName;
    private String client;
    private LocalDate deadline;
    private ProjectStatus status;
    private int completionPercentage;
    private List<String> memberNames;
    public ProjectDTO(Project project) {
        this.id = project.getId();
        this.projectName = project.getProjectName();
        this.client = project.getClient();
        this.deadline = project.getDeadline();
        this.status = project.getStatus();
        this.completionPercentage = project.getCompletionPercentage();
        this.memberNames = project.getMembers().stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
    }
    public Long getId() { return id; }
    public String getProjectName() { return projectName; }
    public String getClient() { return client; }
    public LocalDate getDeadline() { return deadline; }
    public ProjectStatus getStatus() { return status; }
    public int getCompletionPercentage() { return completionPercentage; }
    public List<String> getMemberNames() { return memberNames; }

    public void setId(Long id) { this.id = id; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
    public void setClient(String client) { this.client = client; }
    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }
    public void setStatus(ProjectStatus status) { this.status = status; }
    public void setCompletionPercentage(int completionPercentage) { this.completionPercentage = completionPercentage; }
    public void setMemberNames(List<String> memberNames) { this.memberNames = memberNames; }
}
