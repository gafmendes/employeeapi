package com.project.employeeapi.utils;

import com.project.employeeapi.dto.request.RegistrationDTO;
import com.project.employeeapi.entity.Registration;

public class RegistrationUtilsTest {

	private static final String REGISTRATION_NUMBER = "11999999999";
    private static final String SECURITY_NUMBER = "123456789";
    private static final long REGISTRATION_ID = 1L;
    
    public static RegistrationDTO createFakeDTO() {
    	return RegistrationDTO.builder()
    			.registration(REGISTRATION_NUMBER)
    			.securityNumber(SECURITY_NUMBER)
    			.build();
    }
    
    public static Registration createFakeEntity() {
    	return Registration.builder()
    			.id(REGISTRATION_ID)
    			.registration(REGISTRATION_NUMBER)
    			.securityNumber(SECURITY_NUMBER)
    			.build();
    }
}
