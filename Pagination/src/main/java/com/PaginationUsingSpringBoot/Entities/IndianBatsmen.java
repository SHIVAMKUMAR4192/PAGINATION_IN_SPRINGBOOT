package com.PaginationUsingSpringBoot.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;


@Entity
@Table(name = "indianBatsmen")
@Data
@ToString
public class IndianBatsmen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String batsmenName;
    Integer batsmenAge;
    Integer noOfCentury;
    Integer noOfHalfCentury;


}
