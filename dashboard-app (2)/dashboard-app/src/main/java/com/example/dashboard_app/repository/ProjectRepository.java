package com.example.dashboard_app.repository;

import com.example.dashboard_app.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	
}

