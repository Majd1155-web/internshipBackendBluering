package com.example.internshipBackend.Repository;

import com.example.internshipBackend.entity.LeaveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<LeaveEntity, Integer> {
}
