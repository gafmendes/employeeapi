package com.project.employeeapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.project.employeeapi.dto.request.EmployeeDTO;
import com.project.employeeapi.entity.Employee;

@Mapper
public interface EmployeeMapper {

	EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
	
	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
	Employee toModel(EmployeeDTO employeeDTO);
	
	EmployeeDTO toDTO(Employee employee);
}
