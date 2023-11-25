package com.capg.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByDepartmentCode(String departmentCode);
}
