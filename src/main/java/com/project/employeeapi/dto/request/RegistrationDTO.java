package com.project.employeeapi.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {

	private Long id;

	@NotEmpty
	@Size(min = 9, max = 20)
	private String registration;

	@NotEmpty
	@Size(min = 9, max = 20)
	private String securityNumber;
}
