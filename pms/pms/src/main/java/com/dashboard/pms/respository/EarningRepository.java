package com.dashboard.pms.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dashboard.pms.model.Earning;


public interface EarningRepository extends JpaRepository<Earning, Long> {
    @Query("SELECT e FROM Earning e ORDER BY e.date DESC")
    List<Earning> findRecentEarnings();

	Object getLast7Days();
}
