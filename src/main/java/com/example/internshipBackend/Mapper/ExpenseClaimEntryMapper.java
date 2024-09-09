package com.example.internshipBackend.Mapper;

import com.example.internshipBackend.DTO.ExpenseClaimEntryDTO;
import com.example.internshipBackend.entity.ExpenseclaimentryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ExpenseClaimEntryMapper {
    ExpenseClaimEntryMapper INSTANCE = Mappers.getMapper(ExpenseClaimEntryMapper.class);

    @Mapping(target = "date", expression = "java(new java.util.Date(expenseClaimEntry.getDate().getTime()))")
    ExpenseClaimEntryDTO ExpenseClaimEntryEntityToExpenseClaimEntryDTO(ExpenseclaimentryEntity expenseClaimEntry);

    @Mapping(target = "date", expression = "java(new java.util.Date(expenseClaimEntryDTO.getDate().getTime()))")
    ExpenseclaimentryEntity ExpenseClaimEntryDTOToExpenseClaimEntryEntity(ExpenseClaimEntryDTO expenseClaimEntryDTO);
}
