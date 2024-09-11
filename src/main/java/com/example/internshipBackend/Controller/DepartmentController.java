package com.example.internshipBackend.Controller;

import com.example.internshipBackend.Service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("departments")
@CrossOrigin("*")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("createDepartment")
    @ResponseStatus(HttpStatus.OK)
    public String CreateDepartment(@RequestBody Map<String, Object> departmentDTO) {
        departmentService.createDepartment(departmentDTO);
        return "Department created successfully";
    }

    @GetMapping("getDepartments")
    @ResponseStatus(HttpStatus.OK)
    public List<?> GetDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("getDepartmentById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<?> GetDepartmentById(@PathVariable Integer id) {
        return departmentService.getDepartmentById(id);
    }

    @PatchMapping("updateDepartment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String UpdateDepartment(@PathVariable Integer id, @RequestBody Map<String, Object> departmentDTO) {
        departmentService.updateDepartment(id, departmentDTO);
        return "Department updated successfully";
    }

    @DeleteMapping("deleteDepartment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String DeleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
        return "Department deleted successfully";
    }
}
