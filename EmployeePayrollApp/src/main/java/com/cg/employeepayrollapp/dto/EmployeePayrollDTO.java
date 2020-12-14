package com.cg.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.ToString;

public @ToString class EmployeePayrollDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name is invalid")
	public String name;
	
	@Min(value = 500, message = "Min wage should be more than 500")
	public long salary;
	
	public String gender;
	
	public String startDate;
	
	public String note;
	
	public String profilePic;
	
	public List<String> department;
	
//	public EmployeePayrollDTO(String name, long salary) {
//		this.name=name;
//		this.salary=salary;
//	}
//	
	
}
