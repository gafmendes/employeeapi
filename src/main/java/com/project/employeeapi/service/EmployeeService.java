package com.project.employeeapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.employeeapi.dto.request.EmployeeDTO;
import com.project.employeeapi.dto.response.MessageResponseDTO;
import com.project.employeeapi.entity.Employee;
import com.project.employeeapi.exceptions.EmployeeNotFoundException;
import com.project.employeeapi.mapper.EmployeeMapper;
import com.project.employeeapi.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeService {

	private EmployeeRepository employeeRepository;
	
	private final EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;
	
	public MessageResponseDTO createEmployee(EmployeeDTO employeeDTO) {
		Employee employeeToSave = employeeMapper.toModel(employeeDTO);
		
		Employee savedEmployee = employeeRepository.save(employeeToSave);
		return createMessageResponse(savedEmployee.getId(), "Created employee with ID");
	}
	
	public List<EmployeeDTO> listAll(){
		List<Employee> allEmployee = employeeRepository.findAll();
		return allEmployee.stream()
				.map(employeeMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	public EmployeeDTO findById(Long id) throws EmployeeNotFoundException{
		Employee employee = verifyIfExists(id);
		return employeeMapper.toDTO(employee);
	}
	
	public void delete(Long id) throws EmployeeNotFoundException{
		verifyIfExists(id);
		employeeRepository.deleteById(id);
	}
	
	public MessageResponseDTO updateById(Long id, EmployeeDTO employeeDTO) throws EmployeeNotFoundException{
		verifyIfExists(id);
		
		Employee employeeToUpdate = employeeMapper.toModel(employeeDTO);
		
		Employee updateEmployee = employeeRepository.save(employeeToUpdate);
		return createMessageResponse(updateEmployee.getId(), "Updated employee with ID ");
	}
	
	private Employee verifyIfExists(Long id) throws EmployeeNotFoundException{
		return employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException(id));
	}
	
	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(message + id)
				.build();
	}
}
