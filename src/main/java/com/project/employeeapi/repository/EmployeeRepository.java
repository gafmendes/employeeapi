package com.project.employeeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.employeeapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
