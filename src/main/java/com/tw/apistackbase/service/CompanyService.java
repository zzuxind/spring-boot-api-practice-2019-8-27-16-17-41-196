package com.tw.apistackbase.service;

import com.tw.apistackbase.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    static List<Company> companyList=Company.companyData();

    public List<Company> getCompanies() {
        return companyList;
    }

    public Company geCompanyByID(Integer id){
        for (Company company:companyList){
            if(company.getCompanyID() == id){
                return company;
            }
        }
        return null;
    }
}
