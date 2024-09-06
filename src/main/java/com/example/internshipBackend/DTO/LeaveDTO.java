package com.example.internshipBackend.DTO;

import lombok.Data;
import java.time.LocalDate;
import java.util.Date;

@Data
public class LeaveDTO {
    private int id;
    private int leaveType;
    private Date from;
    private Date to;
    private int numberOfDays;
    private String note;
    private Integer employeeId;
}
