package com.example.internshipBackend.Controller;

import com.example.internshipBackend.Service.ExpenseTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("expensetype")
@CrossOrigin("*")
public class ExpenseTypeController {

    private final ExpenseTypeService expenseTypeService;

    public ExpenseTypeController(ExpenseTypeService expenseTypeService) {
        this.expenseTypeService = expenseTypeService;
    }

    @PostMapping("createExpenseType")
    @ResponseStatus(HttpStatus.OK)
    public String CreateExpenseType(@RequestBody Map<String, Object> expenseTypeDTO) {
        expenseTypeService.createExpenseType(expenseTypeDTO);
        return "expense type created successfully";
    }

    @GetMapping("getExpenseTypes")
    @ResponseStatus(HttpStatus.OK)
    public List<?> GetExpenseType() {
        return expenseTypeService.getExpenseType();
    }

    @GetMapping("getExpenseTypeById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<?> GetExpenseTypeById(@PathVariable Integer id) {
        return expenseTypeService.getExpenseTypeById(id);
    }

    @PatchMapping("updateExpenseType/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String UpdateExpenseType(@PathVariable Integer id, @RequestBody Map<String, Object> expenseTypeDTO) {
        expenseTypeService.updateExpenseType(id, expenseTypeDTO);
        return "expense type updated successfully";
    }

    @DeleteMapping("deleteExpenseType/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String DeleteExpenseType(@PathVariable Integer id) {
        expenseTypeService.deleteExpenseType(id);
        return "expense type deleted successfully";
    }

}
