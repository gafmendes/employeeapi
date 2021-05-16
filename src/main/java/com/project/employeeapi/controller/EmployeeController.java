package com.project.employeeapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.project.employeeapi.dto.request.EmployeeDTO;
import com.project.employeeapi.dto.response.MessageResponseDTO;
import com.project.employeeapi.exceptions.EmployeeNotFoundException;
import com.project.employeeapi.service.EmployeeService;

@RestController
public class EmployeeController {

	private EmployeeService employeeService;
	
	public MessageResponseDTO createEmployee(EmployeeDTO employeeDTO) {
		return employeeService.createEmployee(employeeDTO);
	}
	
	public List<EmployeeDTO> listAll(){
		return employeeService.listAll();
	}

	public EmployeeDTO findById(Long id) throws EmployeeNotFoundException{
		return employeeService.findById(id);
	}
	
	public MessageResponseDTO updateById(Long id, EmployeeDTO employeeDTO) throws EmployeeNotFoundException{
		return employeeService.updateById(id, employeeDTO);
	}
	
	public void deleteById(Long id) throws EmployeeNotFoundException{
		employeeService.delete(id);
	}
}
