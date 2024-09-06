package com.example.internshipBackend.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "department", schema = "blueringinternship")
public class DepartmentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id@Column(name = "id")
    private int id;
    @Basic@Column(name = "name")
    private String name;

}
