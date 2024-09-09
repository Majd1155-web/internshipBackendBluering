package com.example.internshipBackend.Mapper;

import com.example.internshipBackend.DTO.ExpenseClaimDTO;
import com.example.internshipBackend.entity.ExpenseclaimEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ExpenseClaimMapper {
    ExpenseClaimMapper INSTANCE = Mappers.getMapper(ExpenseClaimMapper.class);

    @Mapping(target = "date", expression = "java(new java.util.Date(expenseClaim.getDate().getTime()))")
    ExpenseClaimDTO ExpenseClaimEntityToExpenseClaimDTO(ExpenseclaimEntity expenseClaim);

    @Mapping(target = "date", expression = "java(new java.util.Date(expenseClaimDTO.getDate().getTime()))")
    ExpenseclaimEntity ExpenseClaimDTOToExpenseClaimEntity(ExpenseClaimDTO expenseClaimDTO);
}
