package com.example.internshipBackend.DTO;

import lombok.Data;

@Data
public class EmployeeDTO {
    private int id;
    private String name;
    private String email;
    private String address;
    private Integer departmentId;
}
