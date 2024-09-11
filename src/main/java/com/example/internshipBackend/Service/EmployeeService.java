package com.example.internshipBackend.Service;

import com.example.internshipBackend.DTO.EmployeeDTO;
import com.example.internshipBackend.Mapper.EmployeeMapper;
import com.example.internshipBackend.Repository.DepartmentRepository;
import com.example.internshipBackend.Repository.EmployeeRepository;
import com.example.internshipBackend.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private GeneralService generalService;

    @Autowired
    private EmployeeMapper employeeMapper;

    private final EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void createEmployee(Map<String, Object> employeeDTO) {
        EmployeeEntity employee = new EmployeeEntity();
        generalService.updateEntity(employeeDTO, employee, EmployeeEntity.class);
        employeeRepository.saveAndFlush(employee);
    }

    public List<EmployeeDTO> getEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employee -> {
                    EmployeeDTO employeeDTO = employeeMapper.EmployeeEntityToEmployeeDTO(employee);
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .stream()
                .map(employee -> {
                    EmployeeDTO employeeDTO = employeeMapper.EmployeeEntityToEmployeeDTO(employee);
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeeByDepartment(Integer id) {
        return employeeRepository.findByDepartmentId(id)
                .stream()
                .map(employee -> {
                    EmployeeDTO employeeDTO = employeeMapper.EmployeeEntityToEmployeeDTO(employee);
                    employeeDTO.setDepartmentName(departmentRepository.findById(employeeDTO.getDepartmentId()).get().getName());
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }

    public void updateEmployee(Integer id, Map<String, Object> employeeDTO) {
        EmployeeEntity employee =  employeeRepository.findById(id).get();
        generalService.updateEntity(employeeDTO, employee, EmployeeEntity.class);
        employeeRepository.saveAndFlush(employee);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
