package com.example.internshipBackend.Controller;

import com.example.internshipBackend.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("employee")
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("createEmployee")
    @ResponseStatus(HttpStatus.OK)
    public String CreateEmployee(@RequestBody Map<String, Object> employeeDTO) {
        employeeService.CreateEmployee(employeeDTO);
        return "Employee created successfully";
    }

    @GetMapping("getEmployees")
    @ResponseStatus(HttpStatus.OK)
    public List<?> GetEmployees() {
        return employeeService.GetEmployees();
    }

    @GetMapping("getEmployeeById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<?> GetEmployeeById(@PathVariable Integer id) {
        return  employeeService.GetEmployeeById(id);
    }

    @GetMapping("getEmployeeByDepartment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<?> GetEmployeeByDepartment(@PathVariable Integer id) {
        return employeeService.GetEmployeeByDepartment(id);
    }

    @PatchMapping("updateEmployee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String UpdateEmployee(@PathVariable Integer id, @RequestBody Map<String, Object> employeeDTO) {
        employeeService.UpdateEmployee(id, employeeDTO);
        return "Employee updated successfully";
    }

    @DeleteMapping("deleteEmployee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String DeleteEmployee(@PathVariable Integer id) {
        employeeService.DeleteEmployee(id);
        return "Employee deleted successfully";
    }
}
