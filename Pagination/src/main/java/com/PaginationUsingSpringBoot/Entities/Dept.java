package com.PaginationUsingSpringBoot.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "dept")
@Data
@ToString
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int deptId;
    private String deptName;
    private int noOfEmployeeInDept;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    @JsonBackReference
    private Company company;
}
