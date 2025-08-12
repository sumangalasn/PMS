package com.dashboard.pms.respository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dashboard.pms.model.Task;

import java.time.LocalDate;
import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {
    long countByStatus(String status);

    public static final TaskRepository taskRepo = null;
    @Query("SELECT SUM(t.hoursLogged) FROM Task t")
    Long sumHoursLogged();

    List<Task> findByStatus(String status);
}

