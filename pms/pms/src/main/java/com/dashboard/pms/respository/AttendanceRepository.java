package com.dashboard.pms.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dashboard.pms.model.Attendance;

import java.time.LocalDate;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    @Query("SELECT AVG(a.percentage) FROM Attendance a WHERE a.date = :date")
    Double avgTodayPercentage(LocalDate date);
}
