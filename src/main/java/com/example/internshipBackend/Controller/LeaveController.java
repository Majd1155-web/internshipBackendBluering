package com.example.internshipBackend.Controller;

import com.example.internshipBackend.Service.LeaveService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        leaveService.CreateLeave(leaveDTO);
        return "Leave created successfully";
    }

    @GetMapping("getLeaves")
    @ResponseStatus(HttpStatus.OK)
    public List<?> getLeaves() {
        return leaveService.GetLeaves();
    }

    @GetMapping("getLeaveById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<?> GetLeavesById(@PathVariable Integer id) {
        return leaveService.GetLeavesById(id);
    }

    @PatchMapping("updateLeave/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String UpdateLeave(@PathVariable Integer id, Map<String, Object> leaveDTO) {
        leaveService.UpdateLeaves(id, leaveDTO);
        return "leave update successfully";
    }

    @DeleteMapping("deleteLeave/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String DeleteLeave(@PathVariable Integer id) {
        leaveService.DeleteLeave(id);
        return "Leave deleted successfully";
    }
}
