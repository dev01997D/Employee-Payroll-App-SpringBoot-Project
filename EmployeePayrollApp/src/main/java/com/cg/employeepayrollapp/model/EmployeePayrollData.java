package com.cg.employeepayrollapp.model;

import java.time.LocalDate;
import java.util.List;

import com.cg.employeepayrollapp.dto.EmployeePayrollDTO;

import lombok.Data;

public @Data class EmployeePayrollData {
	private int employeeId;
	private String name;
	private long salary;
	private String gender;
	private String startDate;
	private String note;
	private String profilePic;
	private List<String> department;

	public EmployeePayrollData() {
	}

	public EmployeePayrollData(int employeeId, EmployeePayrollDTO empPayrollDTO) {
		super();
		this.employeeId = employeeId;
		this.name = empPayrollDTO.name;
		this.salary = empPayrollDTO.salary;
		this.gender = empPayrollDTO.gender;
		this.startDate = empPayrollDTO.startDate;
		this.note = empPayrollDTO.note;
		this.profilePic = empPayrollDTO.profilePic;
		this.department = empPayrollDTO.department;
	}
	
	
}
