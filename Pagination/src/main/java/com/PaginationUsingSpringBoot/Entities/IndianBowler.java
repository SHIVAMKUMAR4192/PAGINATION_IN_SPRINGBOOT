package com.PaginationUsingSpringBoot.Entities;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "indianBowler")
@Data
@ToString
public class IndianBowler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String bowlerName;
    Integer bowlerAge;
    Integer noOfWicket;
    Integer noOfFifer;
}
