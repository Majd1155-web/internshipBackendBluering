package com.example.internshipBackend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "leavetype", schema = "blueringinternship")
public class LeavetypeEntity {
    @Id@Column(name = "id")
    private int id;
    @Basic@Column(name = "name")
    private String name;

}
