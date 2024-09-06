package com.example.internshipBackend.Mapper;

import com.example.internshipBackend.DTO.ExpenseClaimDTO;
import com.example.internshipBackend.entity.ExpenseclaimEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ExpenseClaimMapper {
    ExpenseClaimMapper INSTANCE = Mappers.getMapper(ExpenseClaimMapper.class);
    ExpenseClaimDTO ExpenseClaimEntityToExpenseClaimDTO(ExpenseclaimEntity expenseClaim);
    ExpenseclaimEntity ExpenseClaimDTOToExpenseClaimEntity(ExpenseClaimDTO expenseClaimDTO);
}
