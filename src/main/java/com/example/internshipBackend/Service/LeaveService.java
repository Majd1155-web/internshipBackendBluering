package com.example.internshipBackend.Service;

import com.example.internshipBackend.DTO.LeaveDTO;
import com.example.internshipBackend.Mapper.LeaveMapper;
import com.example.internshipBackend.Repository.LeaveRepository;
import com.example.internshipBackend.entity.LeaveEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LeaveService {

    @Autowired
    private LeaveMapper leaveMapper;

    @Autowired
    private GeneralService generalService;

    private final LeaveRepository leaveRepository;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public LeaveService(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    public void CreateLeave(Map<String, Object> leaveDTO) {
        LeaveEntity leave = new LeaveEntity();
        if (leaveDTO.containsKey("from")) {
            String fromDateString = (String) leaveDTO.get("from");
            try {
                leave.setFrom(dateFormat.parse(fromDateString));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            leaveDTO.remove("from");
        }
        if (leaveDTO.containsKey("to")) {
            String toDateString = (String) leaveDTO.get("to");
            try {
                leave.setTo(dateFormat.parse(toDateString));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            leaveDTO.remove("to");
        }
        generalService.updateEntity(leaveDTO, leave, LeaveEntity.class);
        leaveRepository.saveAndFlush(leave);
    }

    public List<LeaveDTO> GetLeaves() {
        return leaveRepository.findAll()
                .stream()
                .map(leave -> {
                    LeaveDTO leaveDTO = leaveMapper.LeaveEntityToLeaveDTO(leave);
                    return leaveDTO;
                })
                .collect(Collectors.toList());
    }

    public List<LeaveDTO> GetLeavesById(Integer id) {
        return leaveRepository.findById(id)
                .stream()
                .map(leave -> {
                    LeaveDTO leaveDTO = leaveMapper.LeaveEntityToLeaveDTO(leave);
                    return leaveDTO;
                })
                .collect(Collectors.toList());
    }

    public List<LeaveDTO> GetLeavesByDate(Date from, Date to) {
        return leaveRepository.findByFromAndTo(from, to)
                .stream()
                .map(leave -> {
                    LeaveDTO leaveDTO = leaveMapper.LeaveEntityToLeaveDTO(leave);
                    return leaveDTO;
                })
                .collect(Collectors.toList());
    }

    public Page<LeaveDTO> GetLeaveByTypeAndEmployee(Integer employeeId, Integer LeaveType, Pageable pageable) {
        return leaveRepository.findByEmployeeIdAndLeaveType(employeeId, LeaveType, pageable)
                .map(leave -> {
                    LeaveDTO leaveDTO = leaveMapper.LeaveEntityToLeaveDTO(leave);
                    return leaveDTO;
                });
    }

    public void UpdateLeaves(Integer id, Map<String, Object> leaveDTO) {
        LeaveEntity leave = leaveRepository.findById(id).get();
        generalService.updateEntity(leaveDTO, leave, LeaveEntity.class);
        leaveRepository.saveAndFlush(leave);
    }

    public void DeleteLeave(Integer id) {
        leaveRepository.deleteById(id);
    }
}
