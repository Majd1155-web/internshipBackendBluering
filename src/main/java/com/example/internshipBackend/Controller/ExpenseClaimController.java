package com.example.internshipBackend.Controller;

import com.example.internshipBackend.Service.ExpenseClaimService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("expenseclaim")
@CrossOrigin("*")
public class ExpenseClaimController {

    private final ExpenseClaimService expenseClaimService;

    public ExpenseClaimController(ExpenseClaimService expenseClaimService) {
        this.expenseClaimService = expenseClaimService;
    }

    @PostMapping("createExpenseClaim")
    @ResponseStatus(HttpStatus.OK)
    public String CreateExpenseClaim(@RequestBody Map<String, Object> expenseClaimDTO) {
        expenseClaimService.CreateExpenseClaim(expenseClaimDTO);
        return "expense claim created successfully";
    }

    @GetMapping("getExpenseClaims")
    @ResponseStatus(HttpStatus.OK)
    public List<?> GetExpenseClaims() {
        return expenseClaimService.GetExpenseClaim();
    }

    @GetMapping("getExpenseClaimById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<?> GetExpenseClaimById(@PathVariable Integer id) {
        return expenseClaimService.GetExpenseClaimById(id);
    }

    @PatchMapping("updateExpenseClaim/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String UpdateExpenseClaim(@PathVariable Integer id, @RequestBody Map<String, Object> expenseClaimDTO) {
        expenseClaimService.UpdateExpenseClaim(id, expenseClaimDTO);
        return "expense claim updated successfully";
    }

    @DeleteMapping("deleteExpenseClaim/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String DeleteExpenseClaim(@PathVariable Integer id) {
        expenseClaimService.DeleteExpenseClaim(id);
        return "expense claim deleted successfully";
    }
}
