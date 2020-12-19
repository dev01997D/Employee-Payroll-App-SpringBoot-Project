package com.cg.employeepayrollapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.employeepayrollapp.model.EmployeePayrollData;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {

	@Query(value = "SELECT * FROM employee_payroll, employee_department WHERE employee_id=id AND department= :department", nativeQuery = true)
	List<EmployeePayrollData> findEmployeesByDepartment(String department);
}
