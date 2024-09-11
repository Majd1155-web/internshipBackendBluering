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

    public void createDepartment(Map<String, Object> departmentDTO) {
        DepartmentEntity department = new DepartmentEntity();
        generalService.updateEntity(departmentDTO, department, DepartmentEntity.class);
        departmentRepository.saveAndFlush(department);
    }

    public List<DepartmentDTO> getDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(department -> {
                    DepartmentDTO departmentDTO = departmentMapper.DepartmentEntityToDepartmentDTO(department);
                    return departmentDTO;
                })
                .collect(Collectors.toList());
    }

    public List<DepartmentDTO> getDepartmentById(Integer id) {
        return departmentRepository.findById(id)
                .stream()
                .map(department -> {
                    DepartmentDTO departmentDTO = departmentMapper.DepartmentEntityToDepartmentDTO(department);
                    return departmentDTO;
                })
                .collect(Collectors.toList());
    }


    public void updateDepartment( Integer id, Map<String, Object> departmentDTO) {
        DepartmentEntity department = departmentRepository.findById(id).get();
        generalService.updateEntity(departmentDTO, department, DepartmentEntity.class);
        departmentRepository.saveAndFlush(department);
    }

    public void deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
    }
}
