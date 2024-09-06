package com.example.internshipBackend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Setter
@Getter
@Entity
@Table(name = "leave", schema = "blueringinternship")
public class LeaveEntity {
    @Id@Column(name = "id")
    private int id;
    @Basic@Column(name = "leave_type")
    private int leaveType;
    @Basic@Column(name = "from")
    private Date from;
    @Basic@Column(name = "to")
    private Date to;
    @Basic@Column(name = "number_of_days")
    private int numberOfDays;
    @Basic@Column(name = "note")
    private String note;
    @Basic@Column(name = "employee_id")
    private Integer employeeId;

}
