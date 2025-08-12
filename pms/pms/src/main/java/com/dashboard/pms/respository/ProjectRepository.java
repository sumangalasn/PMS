package com.dashboard.pms.respository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dashboard.pms.model.Project;

import java.time.LocalDate;
import java.util.List;



public interface ProjectRepository extends JpaRepository<Project, Long> {}
