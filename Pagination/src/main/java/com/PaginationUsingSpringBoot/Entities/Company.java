package com.PaginationUsingSpringBoot.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "company")
@ToString
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int companyId;
    private String companyName;
    private String email;
    private int noOfEmployee;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Employee> employeeList=new ArrayList<>();


    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Dept> deptList=new ArrayList<>();


}
