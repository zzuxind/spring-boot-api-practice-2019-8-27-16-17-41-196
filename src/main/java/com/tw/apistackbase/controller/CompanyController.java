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
        Company company = companyService.getCompanyByID(id);
        if(company==null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return ResponseEntity.ok(company);
        }
    }

    @GetMapping("{id}/employees")
    public ResponseEntity getEmployeesByCompany(@PathVariable Integer id){
        return ResponseEntity.ok(companyService.getEmployeesByCompany(id));
    }

    @PostMapping
    public ResponseEntity addCompany(@RequestBody Company company){
        companyService.addCompany(company);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateCompany(@RequestBody Company company){
        companyService.updateCompany(company);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public  ResponseEntity deleteCompany(@PathVariable Integer id){
        companyService.deleteCompany(id);
        return ResponseEntity.ok().build();
    }


}
