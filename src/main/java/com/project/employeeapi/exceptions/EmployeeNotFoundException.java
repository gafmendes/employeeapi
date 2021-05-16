package com.project.employeeapi.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class EmployeeNotFoundException extends Exception{

	public EmployeeNotFoundException(Long id) {
		super("Employee not found with ID " + id);
	}
}
