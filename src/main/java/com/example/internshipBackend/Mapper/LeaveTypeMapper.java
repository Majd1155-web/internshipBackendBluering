package com.example.internshipBackend.Mapper;

import com.example.internshipBackend.DTO.LeaveDTO;
import com.example.internshipBackend.DTO.LeaveTypeDTO;
import com.example.internshipBackend.entity.LeaveEntity;
import com.example.internshipBackend.entity.LeavetypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LeaveTypeMapper {
    LeaveTypeMapper INSTANCE = Mappers.getMapper(LeaveTypeMapper.class);
    LeaveTypeDTO LeaveTypeEntityToLeaveTypeDTO(LeavetypeEntity leaveType);
    LeavetypeEntity LeaveTypeDTOToLeaveTypeEntity(LeaveTypeDTO leaveTypeDTO);
}
