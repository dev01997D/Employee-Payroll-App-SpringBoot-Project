package com.cg.employeepayrollapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employeepayrollapp.dto.EmployeePayrollDTO;
import com.cg.employeepayrollapp.exceptions.EmployeePayrollException;
import com.cg.employeepayrollapp.model.EmployeePayrollData;
import com.cg.employeepayrollapp.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;
          
@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {
	
	@Autowired
	private EmployeePayrollRepository employeeRepository;


	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		EmployeePayrollData empData= employeeRepository.findAll().stream().filter(empData1 ->empData1.getEmployeeId() == empId).findFirst().orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
		return empData;
	}

	@Override
	public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
		return employeeRepository.findEmployeesByDepartment(department);
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		empData=new EmployeePayrollData(empPayrollDTO);
		log.debug("Emp Data: "+empData.toString());
		return employeeRepository.save(empData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		empData.setName(empPayrollDTO.name);
		empData.setSalary(empPayrollDTO.salary);
		empData.setGender(empPayrollDTO.gender);
		empData.setNote(empPayrollDTO.note);
		empData.setProfilePic(empPayrollDTO.profilePic);
		empData.setStartDate(empPayrollDTO.startDate);
		empData.setDepartment(empPayrollDTO.department);
		return employeeRepository.save(empData);
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		employeeRepository.deleteById(empId);
//		employeeRepository.deleteAll();  To clean all the records from the DB
	}

}
