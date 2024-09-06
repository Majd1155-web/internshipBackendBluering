package com.example.internshipBackend.Mapper;

import com.example.internshipBackend.DTO.EmployeeDTO;
import com.example.internshipBackend.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
    EmployeeDTO EmployeeEntityToEmployeeDTO(EmployeeEntity employee);
    EmployeeEntity EmployeeDTOToEmployeeEntity(EmployeeDTO employeeDTO);
}
