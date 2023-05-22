package com.PaginationUsingSpringBoot.Repository;

import com.PaginationUsingSpringBoot.Entities.Company;
import com.PaginationUsingSpringBoot.Entities.Dept;
import com.PaginationUsingSpringBoot.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
    List<Company>findByCompanyName(String companyName );

    List<Company> findByEmployeeListIn(List<Employee> employees);

    List<Company> findByDeptListIn(List<Dept> depts);
}
