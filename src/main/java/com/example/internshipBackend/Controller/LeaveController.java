package com.example.internshipBackend.Controller;

import com.example.internshipBackend.DTO.LeaveDTO;
import com.example.internshipBackend.Service.LeaveService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("leave")
@CrossOrigin("*")
public class LeaveController {

    private final LeaveService leaveService;

    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @PostMapping("createLeave")
    @ResponseStatus(HttpStatus.OK)
    public String CreateLeave(@RequestBody Map<String, Object> leaveDTO) {
        leaveService.createLeave(leaveDTO);
        return "Leave created successfully";
    }

    @GetMapping("getLeaves")
    @ResponseStatus(HttpStatus.OK)
    public List<?> getLeaves() {
        return leaveService.getLeaves();
    }

    @GetMapping("getLeaveById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<?> GetLeavesById(@PathVariable Integer id) {
        return leaveService.getLeavesById(id);
    }

    @GetMapping("getLeaveByEmpAndType/{employeeId}/{leaveTypeId}")
    @ResponseStatus(HttpStatus.OK)
    public Page<?> GetLeavesByEmpAndId(@PathVariable Integer employeeId, @PathVariable Integer leaveTypeId, Pageable pageable) {
        return leaveService.getLeaveByTypeAndEmployee(employeeId, leaveTypeId, pageable);
    }

    @PostMapping("getLeaveByDateRange")
    @ResponseStatus(HttpStatus.OK)
    public List<LeaveDTO> getLeavesByDateRange(@RequestBody Map<String, Object> dateRange) {
        String fromString = (String) dateRange.get("from");
        String toString = (String) dateRange.get("to");
        Date from = null;
        Date to = null;
        try {
            from = new SimpleDateFormat("yyyy-MM-dd").parse(fromString);
            to = new SimpleDateFormat("yyyy-MM-dd").parse(toString);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format");
        }
        return leaveService.getLeavesByDate(from, to);
    }

    @PatchMapping("updateLeave/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String UpdateLeave(@PathVariable Integer id, @RequestBody Map<String, Object> leaveDTO) {
        leaveService.updateLeaves(id, leaveDTO);
        return "leave update successfully";
    }

    @DeleteMapping("deleteLeave/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String DeleteLeave(@PathVariable Integer id) {
        leaveService.deleteLeave(id);
        return "Leave deleted successfully";
    }
}
