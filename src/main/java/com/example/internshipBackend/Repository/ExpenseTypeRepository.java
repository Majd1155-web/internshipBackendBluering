package com.example.internshipBackend.Repository;

import com.example.internshipBackend.entity.ExpensetypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseTypeRepository extends JpaRepository<ExpensetypeEntity, Integer> {
}
