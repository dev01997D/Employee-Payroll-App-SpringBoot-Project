package com.cg.employeepayrollapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.employeepayrollapp.model.EmployeePayrollData;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer>{

}
