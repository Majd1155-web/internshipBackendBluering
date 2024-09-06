package com.example.internshipBackend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Setter
@Getter
@Entity
@Table(name = "expenseclaim", schema = "blueringinternship")
public class ExpenseclaimEntity {
    @Id@Column(name = "id")
    private int id;
    @Basic@Column(name = "date")
    private Date date;
    @Basic@Column(name = "description")
    private String description;
    @Basic@Column(name = "total")
    private BigDecimal total;
    @Basic@Column(name = "status")
    private String status;
    @Basic@Column(name = "employee_id")
    private Integer employeeId;

}
