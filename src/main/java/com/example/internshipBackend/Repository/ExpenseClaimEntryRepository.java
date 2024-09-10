package com.example.internshipBackend.Repository;

import com.example.internshipBackend.entity.ExpenseclaimentryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseClaimEntryRepository extends JpaRepository<ExpenseclaimentryEntity, Integer> {
    List<ExpenseclaimentryEntity> findByExpenseClaim(Integer expenseClaimId);
}
