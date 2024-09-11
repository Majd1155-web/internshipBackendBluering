package com.example.internshipBackend.Service;

import com.example.internshipBackend.DTO.ExpenseTypeDTO;
import com.example.internshipBackend.Mapper.ExpenseTypeMapper;
import com.example.internshipBackend.Repository.ExpenseTypeRepository;
import com.example.internshipBackend.entity.ExpensetypeEntity;
import org.hibernate.query.sqm.mutation.internal.temptable.LocalTemporaryTableInsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ExpenseTypeService {

    @Autowired
    private GeneralService generalService;

    @Autowired
    private ExpenseTypeMapper expenseTypeMapper;

    private final ExpenseTypeRepository expenseTypeRepository;

    public ExpenseTypeService(ExpenseTypeRepository expenseTypeRepository) {
        this.expenseTypeRepository = expenseTypeRepository;
    }

    public void createExpenseType(Map<String, Object> expenseTypeDTO) {
        ExpensetypeEntity expenseType = new ExpensetypeEntity();
        generalService.updateEntity(expenseTypeDTO, expenseType, ExpensetypeEntity.class);
        expenseTypeRepository.saveAndFlush(expenseType);
    }

    public List<ExpenseTypeDTO> getExpenseType() {
        return expenseTypeRepository.findAll()
                .stream()
                .map(expenseType -> {
                    ExpenseTypeDTO expenseTypeDTO = expenseTypeMapper.ExpenseTypeEntityToExpenseTypeDTO(expenseType);
                    return expenseTypeDTO;
                })
                .collect(Collectors.toList());
    }

    public List<ExpenseTypeDTO> getExpenseTypeById(Integer id) {
        return expenseTypeRepository.findById(id)
                .stream()
                .map(expenseType -> {
                    ExpenseTypeDTO expenseTypeDTO = expenseTypeMapper.ExpenseTypeEntityToExpenseTypeDTO(expenseType);
                    return expenseTypeDTO;
                })
                .collect(Collectors.toList());
    }

    public void updateExpenseType(Integer id, Map<String, Object> expenseTypeDTO) {
        ExpensetypeEntity expenseType = expenseTypeRepository.findById(id).get();
        generalService.updateEntity(expenseTypeDTO, expenseType, ExpensetypeEntity.class);
        expenseTypeRepository.saveAndFlush(expenseType);
    }

    public void deleteExpenseType(Integer id){
        expenseTypeRepository.deleteById(id);
    }

}
