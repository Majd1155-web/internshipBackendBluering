package com.example.internshipBackend.Repository;

import com.example.internshipBackend.entity.ExpenseclaimEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseClaimRepository extends JpaRepository<ExpenseclaimEntity, Integer> {
}
