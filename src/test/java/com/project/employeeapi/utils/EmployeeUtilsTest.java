package com.project.employeeapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import com.project.employeeapi.dto.request.EmployeeDTO;
import com.project.employeeapi.entity.Employee;

public class EmployeeUtilsTest {

	private static final String FIRST_NAME = "Gabriel";
    private static final String LAST_NAME = "Mendes";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);
    
    public static EmployeeDTO createFakeDTO() {
    	return EmployeeDTO.builder()
    			.firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("04-04-2010")
                .registration(Collections.singletonList(RegistrationUtilsTest.createFakeDTO()))
                .build();
    }
    
    public static Employee createFakeEntity () {
    	return Employee.builder()
    			.id(PERSON_ID)
    			.firstName(FIRST_NAME)
    			.lastName(LAST_NAME)
    			.cpf(CPF_NUMBER)
    			.birthDate(BIRTH_DATE)
    			.registration(Collections.singletonList(RegistrationUtilsTest.createFakeEntity()))
    			.build();
    }
}
