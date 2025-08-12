package com.dashboard.pms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class DashboardDTO {
private long totalClients;
private long totalEmployees;
private long totalProjects;
public DashboardDTO() {
	
}

public long getTotalClients() {
	return totalClients;
}

public void setTotalClients(long totalClients) {
	this.totalClients = totalClients;
}

public long getTotalEmployees() {
	return totalEmployees;
}

public void setTotalEmployees(long totalEmployees) {
	this.totalEmployees = totalEmployees;
}

public long getTotalProjects() {
	return totalProjects;
}

public void setTotalProjects(long totalProjects) {
	this.totalProjects = totalProjects;
}

//private long totalHoursLogged;
//private long totalPendingTasks;
//private long totalCompletedTasks;
//private double totalAttendence;
//private long totalResolvedTickets;
//private long unresolvedTickets;
@Data
@AllArgsConstructor
public static class Earning{
	private String date;
	private double amount;
}
}
