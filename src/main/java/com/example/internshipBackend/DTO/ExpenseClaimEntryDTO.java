package com.example.internshipBackend.DTO;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ExpenseClaimEntryDTO {
    private int id;
    private Date date;
    private Integer expenseType;
    private Integer expenseClaim;
    private String description;
    private BigDecimal total;
}
