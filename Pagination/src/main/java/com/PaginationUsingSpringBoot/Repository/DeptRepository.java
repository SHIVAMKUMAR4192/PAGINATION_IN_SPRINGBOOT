package com.PaginationUsingSpringBoot.Repository;

import com.PaginationUsingSpringBoot.Entities.Company;
import com.PaginationUsingSpringBoot.Entities.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeptRepository extends JpaRepository<Dept,Integer> {
    List<Dept> findByCompanyIn(List<Company>companies);

    List<Dept> findByDeptName(String deptName);
}
