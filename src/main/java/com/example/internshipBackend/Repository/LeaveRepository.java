package com.example.internshipBackend.Repository;

import com.example.internshipBackend.entity.LeaveEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveEntity, Integer> {
    List<LeaveEntity> findByFromAndTo(Date from, Date to);
    Page<LeaveEntity> findByEmployeeIdAndLeaveType(Integer employeeId, Integer leaveType, Pageable pageable);
}
