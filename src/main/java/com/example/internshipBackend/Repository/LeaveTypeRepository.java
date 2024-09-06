package com.example.internshipBackend.Repository;

import com.example.internshipBackend.entity.LeavetypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveTypeRepository extends JpaRepository<LeavetypeEntity, Integer> {
}
