package com.project.employeeapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.employeeapi.dto.request.EmployeeDTO;
import com.project.employeeapi.dto.response.MessageResponseDTO;
import com.project.employeeapi.exceptions.EmployeeNotFoundException;
import com.project.employeeapi.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/employee")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class EmployeeController {

	private EmployeeService employeeService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createEmployee(EmployeeDTO employeeDTO) {
		return employeeService.createEmployee(employeeDTO);
	}
	
	@GetMapping
	public List<EmployeeDTO> listAll(){
		return employeeService.listAll();
	}

	@GetMapping("/{id}")
	public EmployeeDTO findById(Long id) throws EmployeeNotFoundException{
		return employeeService.findById(id);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO updateById(Long id, EmployeeDTO employeeDTO) throws EmployeeNotFoundException{
		return employeeService.updateById(id, employeeDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(Long id) throws EmployeeNotFoundException{
		employeeService.delete(id);
	}
}
