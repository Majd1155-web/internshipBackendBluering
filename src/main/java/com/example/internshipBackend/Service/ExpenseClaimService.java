package com.example.internshipBackend.Service;

import com.example.internshipBackend.DTO.ExpenseClaimDTO;
import com.example.internshipBackend.Mapper.ExpenseClaimMapper;
import com.example.internshipBackend.Repository.ExpenseClaimRepository;
import com.example.internshipBackend.entity.ExpenseclaimEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ExpenseClaimService {

    @Autowired
    private GeneralService generalService;

    @Autowired
    private ExpenseClaimMapper expenseClaimMapper;

     private final ExpenseClaimRepository expenseClaimRepository;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public ExpenseClaimService(ExpenseClaimRepository expenseClaimRepository) {
         this.expenseClaimRepository = expenseClaimRepository;
     }

     public void createExpenseClaim(Map<String, Object> expenseClaimDTO) {
         ExpenseclaimEntity expenseClaim = new ExpenseclaimEntity();
         if(expenseClaimDTO.containsKey("date")) {
             String dateString = (String) expenseClaimDTO.get("date");
             try {
                 expenseClaim.setDate( dateFormat.parse(dateString));
             } catch (ParseException e) {
                 e.printStackTrace();
             }
             expenseClaimDTO.remove("date");
         }
         if (expenseClaimDTO.containsKey("total")) {
             Object totalValue = expenseClaimDTO.get("total");
             if (totalValue instanceof Double) {
                 expenseClaim.setTotal(BigDecimal.valueOf((Double) totalValue));
             } else if (totalValue instanceof Integer) {
                 expenseClaim.setTotal(BigDecimal.valueOf((Integer) totalValue));
             }
             expenseClaimDTO.remove("total");
         }
         generalService.updateEntity(expenseClaimDTO, expenseClaim, ExpenseclaimEntity.class);
         expenseClaimRepository.saveAndFlush(expenseClaim);
     }

     public List<ExpenseClaimDTO> getExpenseClaim() {
         return expenseClaimRepository.findAll()
                 .stream()
                 .map(expenseClaim -> {
                     ExpenseClaimDTO expenseClaimDTO = expenseClaimMapper.ExpenseClaimEntityToExpenseClaimDTO(expenseClaim);
                     return expenseClaimDTO;
                 })
                 .collect(Collectors.toList());
     }

    public List<ExpenseClaimDTO> getExpenseClaimById(Integer id) {
        return expenseClaimRepository.findById(id)
                .stream()
                .map(expenseClaim -> {
                    ExpenseClaimDTO expenseClaimDTO = expenseClaimMapper.ExpenseClaimEntityToExpenseClaimDTO(expenseClaim);
                    return expenseClaimDTO;
                })
                .collect(Collectors.toList());
    }

    public void updateExpenseClaim(Integer id, Map<String, Object> expenseClaimDTO) {
         ExpenseclaimEntity expenseClaim = expenseClaimRepository.findById(id).get();
        if(expenseClaimDTO.containsKey("date")) {
            String dateString = (String) expenseClaimDTO.get("date");
            try {
                expenseClaim.setDate( dateFormat.parse(dateString));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            expenseClaimDTO.remove("date");
        }
        if (expenseClaimDTO.containsKey("total")) {
            Object totalValue = expenseClaimDTO.get("total");
            if (totalValue instanceof Double) {
                expenseClaim.setTotal(BigDecimal.valueOf((Double) totalValue));
            } else if (totalValue instanceof Integer) {
                expenseClaim.setTotal(BigDecimal.valueOf((Integer) totalValue));
            }
            expenseClaimDTO.remove("total");
        }
         generalService.updateEntity(expenseClaimDTO, expenseClaim, ExpenseclaimEntity.class);
         expenseClaimRepository.saveAndFlush(expenseClaim);
    }

    public void deleteExpenseClaim(Integer id) {
         expenseClaimRepository.deleteById(id);
    }
}
