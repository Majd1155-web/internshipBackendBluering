package com.example.internshipBackend.Controller;

import com.example.internshipBackend.Service.ExpenseClaimEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("expenseclaimentry")
@CrossOrigin("*")
public class ExpenseClaimEntryController {

    private final ExpenseClaimEntryService expenseClaimEntryService;

    public ExpenseClaimEntryController(ExpenseClaimEntryService expenseClaimEntryService) {
        this.expenseClaimEntryService = expenseClaimEntryService;
    }

    @PostMapping("createExpenseClaimEntry")
    @ResponseStatus(HttpStatus.OK)
    public String CreateExpenseClaimEntry(@RequestBody Map<String, Object> expenseClaimEntryDTO) {
        expenseClaimEntryService.createExpenseClaimEntry(expenseClaimEntryDTO);
        return "expense claim entry created successfully";
    }

    @GetMapping("getExpenseClaimEntry")
    @ResponseStatus(HttpStatus.OK)
    public List<?> GetExpenseClaimEntry() {
        return expenseClaimEntryService.getExpenseClaimEntry();
    }

    @GetMapping("getExpenseClaimEntryById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<?> GetExpenseClaimEntryById(@PathVariable Integer id) {
        return expenseClaimEntryService.getExpenseClaimEntryById(id);
    }

    @PatchMapping("updateExpenseClaimEntry/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String UpdateExpenseClaimEntry(@PathVariable Integer id, @RequestBody Map<String, Object> expenseClaimEntryDTO) {
        expenseClaimEntryService.updateExpenseClaimEntry(id, expenseClaimEntryDTO);
        return "expense claim entry updated successfully";
    }

    @DeleteMapping("deleteExpenseClaimEntry/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String DeleteExpenseClaimEntry(@PathVariable Integer id) {
        expenseClaimEntryService.deleteExpenseClaimEntry(id);
        return "expense claim entry deleted successfully";
    }

    @GetMapping("getTotalClaimForEmployeeByType/{employeeId}/{expenseTypeId}")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getTotalClaimForEmployeeByType(@PathVariable Integer employeeId, @PathVariable Integer expenseTypeId) {
        return expenseClaimEntryService.getTotalClaimForEmployeeByType(employeeId, expenseTypeId);
    }
}
