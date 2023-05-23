package com.PaginationUsingSpringBoot.Controller;

import com.PaginationUsingSpringBoot.Entities.Company;
import com.PaginationUsingSpringBoot.Entities.Dept;
import com.PaginationUsingSpringBoot.Entities.Employee;
import com.PaginationUsingSpringBoot.Repository.CompanyRepository;
import com.PaginationUsingSpringBoot.Repository.DeptRepository;
import com.PaginationUsingSpringBoot.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private DeptRepository deptRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/saveCompanyDetails")
    public List<Company> saveCompanyDetails(@RequestBody List<Company> companies){
        return companyRepository.saveAll(companies);
    }

   @PostMapping("/saveEmployeeDetails")
    public Employee saveEmployeeDetails(@RequestBody Employee employeeList){
        return employeeRepository.save(employeeList);
    }

    @PostMapping("/saveDeptDetails")
    public List<Dept> saveDeptDetails(@RequestBody List<Dept> deptList){
        return deptRepository.saveAll(deptList);
    }

    @GetMapping("/getallDetails")
    public ResponseEntity<?> findAllDetails(@RequestParam(required = false)String companyName,
                                            @RequestParam(required = false)String employeeName,
                                            @RequestParam(required = false)String deptName){
        if(companyName !=null){
            return new ResponseEntity<>(companyRepository.findByCompanyName(companyName), HttpStatus.OK);

        } else if (deptName !=null) {
            List<Dept> depts=deptRepository.findByDeptName(deptName);
            List<Company> companies=companyRepository.findByDeptListIn(depts);
            return new ResponseEntity<>(companies,HttpStatus.OK);

        } else if (employeeName !=null) {
            List<Employee> employees=employeeRepository.findByEmployeeName(employeeName);
            List<Company> companies=companyRepository.findByEmployeeListIn(employees);
            return  new ResponseEntity<>(companies,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(companyRepository.findAll(),HttpStatus.OK);
        }
    }

}
