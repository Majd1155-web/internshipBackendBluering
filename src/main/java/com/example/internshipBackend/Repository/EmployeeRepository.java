package com.example.internshipBackend.Repository;

import com.example.internshipBackend.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    List<EmployeeEntity> findByDepartmentId(Integer departmentId);
}
