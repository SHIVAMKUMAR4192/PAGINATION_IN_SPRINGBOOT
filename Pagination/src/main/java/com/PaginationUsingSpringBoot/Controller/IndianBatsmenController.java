package com.PaginationUsingSpringBoot.Controller;

import com.PaginationUsingSpringBoot.AppConstantShivam;
import com.PaginationUsingSpringBoot.Entities.BatsmenResponse;
import com.PaginationUsingSpringBoot.Entities.IndianBatsmen;
import com.PaginationUsingSpringBoot.Repository.IndianBatsmenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/indianBatsmen")
public class IndianBatsmenController {

    @Autowired
    private IndianBatsmenRepository indianBatsmenRepository;


    @PostMapping("/add")
    public ResponseEntity<List<IndianBatsmen>> addIndianBatsmen(@RequestBody List<IndianBatsmen> indianBatsmen) {
        return new ResponseEntity<>(indianBatsmenRepository.saveAll(indianBatsmen), HttpStatus.CREATED);
    }

    @GetMapping("/getIndianBatsmen")
    public BatsmenResponse getIndianBatsmen(
            @RequestParam(value = "pageNo", defaultValue = AppConstantShivam.DEFAULT_PAGE_NO, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstantShivam.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstantShivam.DEFAULT_BATSMEN_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortOrder", defaultValue = AppConstantShivam.DEFAULT_SORT_ORDER, required = false) String sortOrder
    ) {

//        return indianBatsmenRepository.findAll();
        Sort sort;
        if(sortOrder.equalsIgnoreCase(Sort.Direction.ASC.name())){
            sort = Sort.by(sortBy).ascending();
        }else{
            sort = Sort.by(sortBy).descending();
        }

//        Sort sort = sortOrder.equalsIgnoreCase(Sort.Direction.ASC.name()) ?  Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        PageRequest pageable = PageRequest.of(pageNo,pageSize,sort);

        Page<IndianBatsmen> indianBatsmens = indianBatsmenRepository.findAll(pageable);

        List<IndianBatsmen> listOfIindianBatsmen = indianBatsmens.getContent();

        BatsmenResponse batsmenResponse=new BatsmenResponse();
        batsmenResponse.setIndianBatsmenList(listOfIindianBatsmen);
        batsmenResponse.setPageNo(indianBatsmens.getNumber());
        batsmenResponse.setPageSize(indianBatsmens.getSize());
        batsmenResponse.setTotalPages(indianBatsmens.getTotalPages());
        batsmenResponse.setTotalElements(indianBatsmens.getTotalElements());
        batsmenResponse.setLast(indianBatsmens.isLast());
        return batsmenResponse;

    }
}
