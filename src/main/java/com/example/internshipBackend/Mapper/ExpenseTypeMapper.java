package com.example.internshipBackend.Mapper;

import com.example.internshipBackend.DTO.ExpenseTypeDTO;
import com.example.internshipBackend.entity.ExpensetypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ExpenseTypeMapper {
    ExpenseTypeMapper INSTANCE = Mappers.getMapper(ExpenseTypeMapper.class);
    ExpenseTypeDTO ExpenseTypeEntityToExpenseTypeDTO(ExpensetypeEntity expenseType);
    ExpensetypeEntity ExpenseTypeDTOToExpenseTypeEntity(ExpenseTypeDTO expenseTypeDTO);
}
