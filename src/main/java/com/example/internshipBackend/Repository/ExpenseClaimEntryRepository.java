package com.example.internshipBackend.Repository;

import com.example.internshipBackend.entity.ExpenseclaimentryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenseClaimEntryRepository extends JpaRepository<ExpenseclaimentryEntity, Integer> {
    List<ExpenseclaimentryEntity> findByExpenseClaim(Integer expenseClaimId);

    @Query("SELECT et.name, SUM(ece.total) " +
            "FROM ExpenseclaimentryEntity ece " +
            "JOIN ExpensetypeEntity et ON ece.expenseType = et.id " +  // Join with ExpensetypeEntity based on the ID
            "JOIN ExpenseclaimEntity ec ON ece.expenseClaim = ec.id " +
            "WHERE ec.employeeId = :employeeId " +
            "GROUP BY et.name")
    List<Object[]> findTotalClaimsByTypeForEmployee(@Param("employeeId") Integer employeeId);
}
