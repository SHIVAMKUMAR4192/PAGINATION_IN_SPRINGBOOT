package com.PaginationUsingSpringBoot.Repository;

import com.PaginationUsingSpringBoot.Entities.IndianBatsmen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndianBatsmenRepository extends JpaRepository<IndianBatsmen,Integer> {
}
