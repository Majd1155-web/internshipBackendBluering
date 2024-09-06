package com.example.internshipBackend.Service;

import com.example.internshipBackend.DTO.DepartmentDTO;
import com.example.internshipBackend.Mapper.DepartmentMapper;
import com.example.internshipBackend.Repository.DepartmentRepository;
import com.example.internshipBackend.entity.DepartmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private GeneralService generalService;

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public void CreateDepartment(Map<String, Object> departmentDTO) {
        DepartmentEntity department = new DepartmentEntity();
        generalService.updateEntity(departmentDTO, department, DepartmentEntity.class);
        departmentRepository.saveAndFlush(department);
    }

    public List<DepartmentDTO> GetDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(department -> {
                    DepartmentDTO departmentDTO = departmentMapper.DepartmentEntityToDepartmentDTO(department);
                    return departmentDTO;
                })
                .collect(Collectors.toList());
    }

    public List<DepartmentDTO> GetDepartmentById(Integer id) {
        return departmentRepository.findById(id)
                .stream()
                .map(department -> {
                    DepartmentDTO departmentDTO = departmentMapper.DepartmentEntityToDepartmentDTO(department);
                    return departmentDTO;
                })
                .collect(Collectors.toList());
    }


    public void UpdateDepartment( Integer id, Map<String, Object> departmentDTO) {
        DepartmentEntity department = departmentRepository.findById(id).get();
        generalService.updateEntity(departmentDTO, department, DepartmentEntity.class);
        departmentRepository.saveAndFlush(department);
    }

    public void DeleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
    }
}
