package com.dashboard.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.pms.dto.DashboardDTO;
import com.dashboard.pms.respository.ClientRepository;
import com.dashboard.pms.respository.EmployeeRepository;
import com.dashboard.pms.respository.ProjectRepository;

@Service
public class DashboardService {

    @Autowired private ClientRepository clientRepo;
    @Autowired private EmployeeRepository employeeRepo;
    @Autowired private ProjectRepository projectRepo;

    public DashboardDTO getDashboardData() {
        DashboardDTO dto = new DashboardDTO();

        dto.setTotalClients(clientRepo.count());
        dto.setTotalEmployees(employeeRepo.count());
        dto.setTotalProjects(projectRepo.count());
//        dto.setTotalPaidInvoices(invoiceRepo.countByPaid(true));
//        dto.setTotalHoursLogged(taskRepo.sumHoursLogged());
//        dto.setTotalPendingTasks(taskRepo.countByStatus("PENDING"));
//        dto.setTotalCompletedTasks(taskRepo.countByStatus("COMPLETED"));
//        dto.setTodayAttendance(attendanceRepo.avgTodayPercentage(LocalDate.now()));
//        dto.setResolvedTickets(ticketRepo.countByStatus("RESOLVED"));
//        dto.setUnresolvedTickets(ticketRepo.countByStatus("UNRESOLVED"));
//        dto.setRecentEarnings(earningRepo.getLast7Days());

        return dto;
    }
}
