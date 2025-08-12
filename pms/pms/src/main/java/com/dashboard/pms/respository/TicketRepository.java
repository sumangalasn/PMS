package com.dashboard.pms.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dashboard.pms.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    long countByStatus(String status);
}
