package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Company;
import com.tw.apistackbase.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping
    public ResponseEntity getCompanies(@RequestParam(required = false) Integer page,@RequestParam(required = false) Integer pageSize){
        return ResponseEntity.ok(companyService.getCompanies(page,pageSize));
    }

    @GetMapping("{id}")
    public ResponseEntity getCompanyByID(@PathVariable Integer id){
        Company company = companyService.geCompanyByID(id);
        if(company==null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return ResponseEntity.ok(company);
        }
    }




}
