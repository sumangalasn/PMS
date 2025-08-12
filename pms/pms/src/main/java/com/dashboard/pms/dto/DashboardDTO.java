package com.dashboard.pms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class DashboardDTO {
private long totalClients;
private long totalEmployees;
private long totalProjects;
private long totalHoursLogged;
private long totalPendingTasks;
private long totalCompletedTasks;
private double totalAttendance;
private long totalResolvedTickets;
private long unresolvedTickets;
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
public long getTotalHoursLogged() {
	return totalHoursLogged;
}
public void setTotalHoursLogged(long totalHoursLogged) {
	this.totalHoursLogged = totalHoursLogged;
}
public long getTotalPendingTasks() {
	return totalPendingTasks;
}
public void setTotalPendingTasks(long totalPendingTasks) {
	this.totalPendingTasks = totalPendingTasks;
}
public long getTotalCompletedTasks() {
	return totalCompletedTasks;
}
public void setTotalCompletedTasks(long totalCompletedTasks) {
	this.totalCompletedTasks = totalCompletedTasks;
}
public double getTotalAttendance() {
	return totalAttendance;
}
public void setTotalAttendance(double totalAttendance) {
	this.totalAttendance = totalAttendance;
}
public long getTotalResolvedTickets() {
	return totalResolvedTickets;
}
public void setTotalResolvedTickets(long totalResolvedTickets) {
	this.totalResolvedTickets = totalResolvedTickets;
}
public long getUnresolvedTickets() {
	return unresolvedTickets;
}
public void setUnresolvedTickets(long unresolvedTickets) {
	this.unresolvedTickets = unresolvedTickets;
}
public void setTodayAttendance(Double avgTodayPercentage) {
	// TODO Auto-generated method stub
	
}
public void setResolvedTickets(long countByStatus) {
	// TODO Auto-generated method stub
	
}
public void setRecentEarnings(Object last7Days) {
	// TODO Auto-generated method stub
	
}
}
