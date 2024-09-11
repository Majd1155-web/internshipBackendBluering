package com.example.internshipBackend.Service;

import com.example.internshipBackend.DTO.ExpenseClaimEntryDTO;
import com.example.internshipBackend.Mapper.ExpenseClaimEntryMapper;
import com.example.internshipBackend.Repository.ExpenseClaimEntryRepository;
import com.example.internshipBackend.Repository.ExpenseClaimRepository;
import com.example.internshipBackend.entity.ExpenseclaimentryEntity;
import com.example.internshipBackend.entity.ExpenseclaimEntity;
import com.example.internshipBackend.entity.ExpensetypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    private final ExpenseClaimRepository expenseClaimRepository;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public ExpenseClaimEntryService(ExpenseClaimEntryRepository expenseClaimEntryRepository, ExpenseClaimRepository expenseClaimRepository) {
        this.expenseClaimEntryRepository = expenseClaimEntryRepository;
        this.expenseClaimRepository = expenseClaimRepository;
    }

    public void createExpenseClaimEntry(Map<String, Object> expenseClaimEntryDTO) {
        ExpenseclaimentryEntity expenseClaimEntry = new ExpenseclaimentryEntity();
        if(expenseClaimEntryDTO.containsKey("date")) {
            String dateString = (String) expenseClaimEntryDTO.get("date");
            try {
                expenseClaimEntry.setDate( dateFormat.parse(dateString));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            expenseClaimEntryDTO.remove("date");
        }
        if (expenseClaimEntryDTO.containsKey("total")) {
            Object totalValue = expenseClaimEntryDTO.get("total");
            if (totalValue instanceof Double) {
                expenseClaimEntry.setTotal(BigDecimal.valueOf((Double) totalValue));
            } else if (totalValue instanceof Integer) {
                expenseClaimEntry.setTotal(BigDecimal.valueOf((Integer) totalValue));
            }
            expenseClaimEntryDTO.remove("total");
        }
        generalService.updateEntity(expenseClaimEntryDTO, expenseClaimEntry, ExpenseclaimentryEntity.class);
        expenseClaimEntryRepository.saveAndFlush(expenseClaimEntry);

        updateExpenseClaimTotal(expenseClaimEntry.getExpenseClaim());
    }

    public List<ExpenseClaimEntryDTO> getExpenseClaimEntry() {
        return expenseClaimEntryRepository.findAll()
                .stream()
                .map(expenseClaimEntry -> {
                    ExpenseClaimEntryDTO expenseClaimEntryDTO = expenseClaimEntryMapper.ExpenseClaimEntryEntityToExpenseClaimEntryDTO(expenseClaimEntry);
                    return expenseClaimEntryDTO;
                })
                .collect(Collectors.toList());
    }

    public List<ExpenseClaimEntryDTO> getExpenseClaimEntryById(Integer id) {
        return expenseClaimEntryRepository.findById(id)
                .stream()
                .map(expenseClaimEntry -> {
                    ExpenseClaimEntryDTO expenseClaimEntryDTO = expenseClaimEntryMapper.ExpenseClaimEntryEntityToExpenseClaimEntryDTO(expenseClaimEntry);
                    return expenseClaimEntryDTO;
                })
                .collect(Collectors.toList());
    }

    public void updateExpenseClaimEntry(Integer id, Map<String, Object> expenseClaimEntryDTO) {
        ExpenseclaimentryEntity expenseClaimEntry = expenseClaimEntryRepository.findById(id).get();
        if(expenseClaimEntryDTO.containsKey("date")) {
            String dateString = (String) expenseClaimEntryDTO.get("date");
            try {
                expenseClaimEntry.setDate( dateFormat.parse(dateString));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            expenseClaimEntryDTO.remove("date");
        }
        if (expenseClaimEntryDTO.containsKey("total")) {
            Object totalValue = expenseClaimEntryDTO.get("total");
            if (totalValue instanceof Double) {
                expenseClaimEntry.setTotal(BigDecimal.valueOf((Double) totalValue));
            } else if (totalValue instanceof Integer) {
                expenseClaimEntry.setTotal(BigDecimal.valueOf((Integer) totalValue));
            }
            expenseClaimEntryDTO.remove("total");
        }
        generalService.updateEntity(expenseClaimEntryDTO, expenseClaimEntry, ExpenseclaimentryEntity.class);
        expenseClaimEntryRepository.saveAndFlush(expenseClaimEntry);

        updateExpenseClaimTotal(expenseClaimEntry.getExpenseClaim());
    }

    public void deleteExpenseClaimEntry(Integer id) {
        ExpenseclaimentryEntity expenseClaimEntry = expenseClaimEntryRepository.findById(id).orElse(null);
        if (expenseClaimEntry != null) {
            expenseClaimEntryRepository.deleteById(id);

            updateExpenseClaimTotal(expenseClaimEntry.getExpenseClaim());
        }
    }

    private void updateExpenseClaimTotal(Integer claimId) {
        List<ExpenseclaimentryEntity> entries = expenseClaimEntryRepository.findByExpenseClaim(claimId);
        BigDecimal totalSum = entries.stream()
                .map(ExpenseclaimentryEntity::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        ExpenseclaimEntity expenseClaim = expenseClaimRepository.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Expense claim not found"));
        expenseClaim.setTotal(totalSum);
        expenseClaimRepository.save(expenseClaim);
    }

    public Map<String, BigDecimal> getTotalClaimsByTypeForEmployee(Integer employeeId) {
        List<Object[]> results = expenseClaimEntryRepository.findTotalClaimsByTypeForEmployee(employeeId);
        return results.stream().collect(Collectors.toMap(
                result -> (String) result[0],
                result -> (BigDecimal) result[1]
        ));
    }
}
