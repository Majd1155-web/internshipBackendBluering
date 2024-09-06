package com.example.internshipBackend.DTO;

import lombok.Data;
import java.math.BigDecimal;
import java.sql.Date;

@Data
public class ExpenseClaimDTO {
    private int id;
    private Date date;
    private String description;
    private BigDecimal total;
    private String status;
    private Integer employeeId;
}
