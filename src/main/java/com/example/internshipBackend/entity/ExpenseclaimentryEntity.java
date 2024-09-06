package com.example.internshipBackend.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Setter
@Getter
@Entity
@Table(name = "expenseclaimentry", schema = "blueringinternship")
public class ExpenseclaimentryEntity {
    @Id@Column(name = "id")
    private int id;
    @Basic@Column(name = "date")
    private Date date;
    @Basic@Column(name = "expense_type")
    private Integer expenseType;
    @Basic@Column(name = "expense_claim")
    private Integer expenseClaim;
    @Basic@Column(name = "description")
    private String description;
    @Basic@Column(name = "total")
    private BigDecimal total;

}
