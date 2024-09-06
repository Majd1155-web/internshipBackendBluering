package com.example.internshipBackend.Mapper;

import com.example.internshipBackend.DTO.DepartmentDTO;
import com.example.internshipBackend.entity.DepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);
    DepartmentDTO DepartmentEntityToDepartmentDTO(DepartmentEntity department);
    DepartmentEntity DepartmentDTOToDepartmentEntity(DepartmentDTO departmentDTO);
}
