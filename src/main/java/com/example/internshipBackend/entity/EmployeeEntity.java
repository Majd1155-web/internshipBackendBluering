package com.example.internshipBackend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "employee", schema = "blueringinternship")
public class EmployeeEntity {
    @Id@Column(name = "id")
    private int id;
    @Basic@Column(name = "name")
    private String name;
    @Basic@Column(name = "email")
    private String email;
    @Basic@Column(name = "address")
    private String address;
    @Basic@Column(name = "department_id")
    private Integer departmentId;

}
