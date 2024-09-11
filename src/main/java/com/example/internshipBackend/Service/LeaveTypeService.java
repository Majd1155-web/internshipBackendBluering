package com.example.internshipBackend.Service;

import com.example.internshipBackend.DTO.LeaveTypeDTO;
import com.example.internshipBackend.Mapper.LeaveTypeMapper;
import com.example.internshipBackend.Repository.LeaveTypeRepository;
import com.example.internshipBackend.entity.LeavetypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LeaveTypeService {

    @Autowired
    private LeaveTypeMapper leaveTypeMapper;

    @Autowired
    private GeneralService generalService;

    private final LeaveTypeRepository leaveTypeRepository;

    public LeaveTypeService(LeaveTypeRepository leaveTypeRepository) {
        this.leaveTypeRepository = leaveTypeRepository;
    }

    public void createLeaveType(Map<String, Object> leaveTypeDTO) {
        LeavetypeEntity leaveType = new LeavetypeEntity();
        generalService.updateEntity(leaveTypeDTO, leaveType, LeavetypeEntity.class);
        leaveTypeRepository.saveAndFlush(leaveType);
    }

    public List<LeaveTypeDTO> getLeaveTypes() {
        return leaveTypeRepository.findAll()
                .stream()
                .map(leaveType -> {
                    LeaveTypeDTO leaveTypeDTO = leaveTypeMapper.LeaveTypeEntityToLeaveTypeDTO(leaveType);
                    return leaveTypeDTO;
                })
                .collect(Collectors.toList());
    }

    public List<LeaveTypeDTO> getLeaveTypesById(Integer id) {
        return leaveTypeRepository.findById(id)
                .stream()
                .map(leaveType -> {
                    LeaveTypeDTO leaveTypeDTO = leaveTypeMapper.LeaveTypeEntityToLeaveTypeDTO(leaveType);
                    return leaveTypeDTO;
                })
                .collect(Collectors.toList());
    }

    public void updateLeaveTypes(Integer id, Map<String, Object> leaveTypeDTO) {
        LeavetypeEntity leaveType = leaveTypeRepository.findById(id).get();
        generalService.updateEntity(leaveTypeDTO, leaveType, LeavetypeEntity.class);
        leaveTypeRepository.saveAndFlush(leaveType);
    }

    public void deleteLeaveType(Integer id) {
        leaveTypeRepository.deleteById(id);
    }
}
