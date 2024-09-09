package com.example.internshipBackend.Service;

import com.example.internshipBackend.DTO.ExpenseClaimEntryDTO;
import com.example.internshipBackend.Mapper.ExpenseClaimEntryMapper;
import com.example.internshipBackend.Repository.ExpenseClaimEntryRepository;
import com.example.internshipBackend.entity.ExpenseclaimentryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ExpenseClaimEntryService {

    @Autowired
    private GeneralService generalService;

    @Autowired
    private ExpenseClaimEntryMapper expenseClaimEntryMapper;

    private final ExpenseClaimEntryRepository expenseClaimEntryRepository;

    public ExpenseClaimEntryService(ExpenseClaimEntryRepository expenseClaimEntryRepository) {
        this.expenseClaimEntryRepository = expenseClaimEntryRepository;
    }

    public void CreateExpenseClaimEntry(Map<String, Object> expenseClaimEntryDTO) {
        ExpenseclaimentryEntity expenseClaimEntry = new ExpenseclaimentryEntity();
        generalService.updateEntity(expenseClaimEntryDTO, expenseClaimEntry, ExpenseclaimentryEntity.class);
        expenseClaimEntryRepository.saveAndFlush(expenseClaimEntry);
    }

    public List<ExpenseClaimEntryDTO> GetExpenseClaimEntry() {
        return expenseClaimEntryRepository.findAll()
                .stream()
                .map(expenseClaimEntry -> {
                    ExpenseClaimEntryDTO expenseClaimEntryDTO = expenseClaimEntryMapper.ExpenseClaimEntryEntityToExpenseClaimEntryDTO(expenseClaimEntry);
                    return expenseClaimEntryDTO;
                })
                .collect(Collectors.toList());
    }

    public List<ExpenseClaimEntryDTO> GetExpenseClaimEntryById(Integer id) {
        return expenseClaimEntryRepository.findById(id)
                .stream()
                .map(expenseClaimEntry -> {
                    ExpenseClaimEntryDTO expenseClaimEntryDTO = expenseClaimEntryMapper.ExpenseClaimEntryEntityToExpenseClaimEntryDTO(expenseClaimEntry);
                    return expenseClaimEntryDTO;
                })
                .collect(Collectors.toList());
    }

    public void UpdateExpenseClaimEntry(Integer id, Map<String, Object> expenseClaimEntryDTO) {
        ExpenseclaimentryEntity expenseClaimEntry = expenseClaimEntryRepository.findById(id).get();
        generalService.updateEntity(expenseClaimEntryDTO, expenseClaimEntry, ExpenseclaimentryEntity.class);
        expenseClaimEntryRepository.saveAndFlush(expenseClaimEntry);
    }

    public void DeleteExpenseClaimEntry(Integer id) {
        expenseClaimEntryRepository.deleteById(id);
    }
}
