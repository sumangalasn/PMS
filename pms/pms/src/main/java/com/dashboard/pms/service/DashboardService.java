package com.dashboard.pms.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.pms.dto.DashboardDTO;
import com.dashboard.pms.respository.AttendanceRepository;
import com.dashboard.pms.respository.ClientRepository;
import com.dashboard.pms.respository.EarningRepository;
import com.dashboard.pms.respository.EmployeeRepository;
import com.dashboard.pms.respository.ProjectRepository;
import com.dashboard.pms.respository.TaskRepository;
import com.dashboard.pms.respository.TicketRepository;

@Service
public class DashboardService {

    @Autowired private ClientRepository clientRepo;
    @Autowired private EmployeeRepository employeeRepo;
    @Autowired private ProjectRepository projectRepo;
    @Autowired private TaskRepository taskRepo;
    @Autowired private AttendanceRepository attendanceRepo;
    @Autowired private TicketRepository ticketRepo;
    @Autowired private EarningRepository earningRepo;

    public DashboardDTO getDashboardData() {
        DashboardDTO dto = new DashboardDTO();

        dto.setTotalClients(clientRepo.count());
        dto.setTotalEmployees(employeeRepo.count());
        dto.setTotalProjects(projectRepo.count());

        Long totalHours = taskRepo.sumHoursLogged();
        dto.setTotalHoursLogged(totalHours != null ? totalHours : 0);

        dto.setTotalPendingTasks(taskRepo.countByStatus("PENDING"));
        dto.setTotalCompletedTasks(taskRepo.countByStatus("COMPLETED"));

        Double avgAttendance = attendanceRepo.avgTodayPercentage(LocalDate.now());
        dto.setTodayAttendance(avgAttendance != null ? avgAttendance : 0);

        dto.setResolvedTickets(ticketRepo.countByStatus("RESOLVED"));
        dto.setUnresolvedTickets(ticketRepo.countByStatus("UNRESOLVED"));

        dto.setRecentEarnings(earningRepo.getLast7Days());

        return dto;
    }
}
