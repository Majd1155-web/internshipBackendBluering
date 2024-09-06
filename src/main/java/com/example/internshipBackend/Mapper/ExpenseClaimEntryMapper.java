package com.example.internshipBackend.Mapper;

import com.example.internshipBackend.DTO.ExpenseClaimEntryDTO;
import com.example.internshipBackend.entity.ExpenseclaimentryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ExpenseClaimEntryMapper {
    ExpenseClaimEntryMapper INSTANCE = Mappers.getMapper(ExpenseClaimEntryMapper.class);
    ExpenseClaimEntryDTO ExpenseClaimEntryEntityToExpenseClaimEntryDTO(ExpenseclaimentryEntity expenseClaimEntry);
    ExpenseclaimentryEntity ExpenseClaimEntryDTOToExpenseClaimEntryEntity(ExpenseClaimEntryDTO expenseClaimEntryDTO);
}
