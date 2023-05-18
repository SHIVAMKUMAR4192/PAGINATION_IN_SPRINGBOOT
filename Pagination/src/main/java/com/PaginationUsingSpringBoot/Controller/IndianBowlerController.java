package com.PaginationUsingSpringBoot.Controller;

import com.PaginationUsingSpringBoot.AppConstantShivam;
import com.PaginationUsingSpringBoot.Entities.BowlerResponse;
import com.PaginationUsingSpringBoot.Entities.IndianBowler;
import com.PaginationUsingSpringBoot.Repository.IndianBowlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/indianBowler")
public class IndianBowlerController {

    @Autowired
    private IndianBowlerRepository indianBowlerRepository;

    @PostMapping("/add")
    public ResponseEntity <List<IndianBowler>>  addIndianBowler(@RequestBody List<IndianBowler> indianBowler){
        return new ResponseEntity<>(indianBowlerRepository.saveAll(indianBowler), HttpStatus.CREATED);
    }
    @GetMapping("/getIndianBowler")
    public BowlerResponse getIndianBowler(
            @RequestParam(value = "pageNo",defaultValue = AppConstantShivam.DEFAULT_PAGE_NO,required = false)int pageNo,
            @RequestParam(value = "pageSize",defaultValue = AppConstantShivam.DEFAULT_PAGE_SIZE,required = false)int pageSize,
            @RequestParam(value = "sortBy",defaultValue = AppConstantShivam.DEFAULT_BOWLER_SORT_BY,required = false)String sortBy,
            @RequestParam(value = "sortOrder",defaultValue = AppConstantShivam.DEFAULT_SORT_ORDER,required = false)String sortOrder
    ){
          Sort sort=sortOrder.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
          PageRequest pageable = PageRequest.of(pageNo,pageSize,sort);

          Page<IndianBowler> indianBowlers=indianBowlerRepository.findAll(pageable);

          List<IndianBowler> indianBowlerList=indianBowlers.getContent();

          BowlerResponse bowlerResponse=new BowlerResponse();
          bowlerResponse.setIndianBowlerList(indianBowlerList);
          bowlerResponse.setPageNo(indianBowlers.getNumber());
          bowlerResponse.setPageSize(indianBowlers.getSize());
          bowlerResponse.setTotalPages(indianBowlers.getTotalPages());
          bowlerResponse.setTotalElements(indianBowlers.getTotalElements());
          bowlerResponse.setLast(indianBowlers.isLast());
            return bowlerResponse;


//        return this.indianBowlerRepository.findAll();
    }
}
