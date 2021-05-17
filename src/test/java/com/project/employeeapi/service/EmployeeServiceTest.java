package com.project.employeeapi.service;

import static one.digitalinnovation.personapi.utils.PersonUtils.createFakeDTO;
import static one.digitalinnovation.personapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.employeeapi.dto.request.EmployeeDTO;
import com.project.employeeapi.dto.response.MessageResponseDTO;
import com.project.employeeapi.entity.Employee;
import com.project.employeeapi.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeService employeeService;

	@Test
	void testGivenEmployeeDTOThenReturnSavedMessage() {
		EmployeeDTO employeeDTO = createFakeDTO();
		Employee expectedSavedEmployee = createFakeEntity();

		when(employeeRepository.save(any(Employee.class))).thenReturn(expectedSavedEmployee);

		MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedEmployee.getId());
		MessageResponseDTO succesMessage = employeeService.createEmployee(employeeDTO);

		assertEquals(expectedSuccessMessage, succesMessage);
	}

	private MessageResponseDTO createExpectedMessageResponse(Long id) {
		return MessageResponseDTO
				.builder()
				.message("Created employee with ID " + id)
				.build();
	}
}
