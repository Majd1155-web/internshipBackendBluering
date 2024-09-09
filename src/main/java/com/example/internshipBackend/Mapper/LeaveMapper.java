package com.example.internshipBackend.Mapper;

import com.example.internshipBackend.DTO.LeaveDTO;
import com.example.internshipBackend.entity.LeaveEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LeaveMapper {
    LeaveMapper INSTANCE = Mappers.getMapper(LeaveMapper.class);

    @Mapping(target = "from", expression = "java(new java.util.Date(leaveEntity.getFrom().getTime()))")
    @Mapping(target = "to", expression = "java(new java.util.Date(leaveEntity.getTo().getTime()))")
    LeaveDTO LeaveEntityToLeaveDTO(LeaveEntity leaveEntity);

    @Mapping(target = "from", expression = "java(new java.sql.Date(leaveDTO.getFrom().getTime()))")
    @Mapping(target = "to", expression = "java(new java.sql.Date(leaveDTO.getTo().getTime()))")
    LeaveEntity LeaveDTOToLeaveEntity(LeaveDTO leaveDTO);
}
