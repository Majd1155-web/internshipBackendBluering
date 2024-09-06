package com.example.internshipBackend.Mapper;

import com.example.internshipBackend.DTO.LeaveDTO;
import com.example.internshipBackend.entity.LeaveEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LeaveMapper {
    LeaveMapper INSTANCE = Mappers.getMapper(LeaveMapper.class);
    LeaveDTO LeaveEntityToLeaveDTO(LeaveEntity leaveEntity);
    LeaveEntity LeaveDTOToLeaveEntity(LeaveDTO leaveDTO);
}
