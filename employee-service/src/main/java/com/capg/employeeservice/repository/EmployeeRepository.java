package com.capg.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
