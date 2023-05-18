package com.PaginationUsingSpringBoot.Repository;

import com.PaginationUsingSpringBoot.Entities.IndianBatsmen;
import com.PaginationUsingSpringBoot.Entities.IndianBowler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndianBowlerRepository extends JpaRepository<IndianBowler,Integer> {
}
