package com.example.internshipBackend.Repository;

import com.example.internshipBackend.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {
}
