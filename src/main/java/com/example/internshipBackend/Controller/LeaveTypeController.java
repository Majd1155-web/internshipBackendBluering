package com.example.internshipBackend.Controller;

import com.example.internshipBackend.Service.LeaveTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("leaveType")
@CrossOrigin("*")
public class LeaveTypeController {

    private final LeaveTypeService leaveTypeService;

    public LeaveTypeController(LeaveTypeService leaveTypeService) {
        this.leaveTypeService = leaveTypeService;
    }

    @PostMapping("createLeaveType")
    @ResponseStatus(HttpStatus.OK)
    public String CreateLeaveType(@RequestBody Map<String, Object> leaveTypeDTO) {
        leaveTypeService.createLeaveType(leaveTypeDTO);
        return "Leave type created successfully";
    }

    @GetMapping("getLeaveTypes")
    @ResponseStatus(HttpStatus.OK)
    public List<?> GetLeaveTypes() {
        return  leaveTypeService.getLeaveTypes();
    }

    @GetMapping("getLeaveTypesById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<?> GetLeaveTypesById(@PathVariable Integer id) {
        return  leaveTypeService.getLeaveTypesById(id);
    }

    @PatchMapping("updateLeaveType/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String UpdateLeaveType(@PathVariable Integer id, @RequestBody Map<String, Object> leaveTypeDTO) {
        leaveTypeService.updateLeaveTypes(id, leaveTypeDTO);
        return "Leave type updated successfully";
    }

    @DeleteMapping("deleteLeaveType/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String DeleteLeaveType(@PathVariable Integer id) {
        leaveTypeService.deleteLeaveType(id);
        return "Leave Type deleted successfully";
    }
}
