package com.PaginationUsingSpringBoot.Repository;

import com.PaginationUsingSpringBoot.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByEmployeeName(String employeeName);
}
