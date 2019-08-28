package com.tw.apistackbase.service;

import com.tw.apistackbase.entity.Company;
import com.tw.apistackbase.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    static List<Company> companyList=Company.companyData();

    public List<Company> getCompanies(Integer page,Integer pageSize) {
        if(page!=null && pageSize!=null){
            int start=pageSize*(page-1);
            List<Company> pageCompaniesList=companyList.subList(start,start+pageSize);
            return pageCompaniesList;
        }
        return  companyList;
    }

    public Company getCompanyByID(Integer id){
        for (Company company:companyList){
            if(company.getCompanyID() == id){
                return company;
            }
        }
        return null;
    }

    public List<Employee> getEmployeesByCompany(Integer companyID){
        Company company=getCompanyByID(companyID);
        return company.getEmployees();
    }

    public void addCompany(Company company) {
        companyList.add(company);
    }

    public void updateCompany(Company company) {
        Company gettedCompany=getCompanyByID(company.getCompanyID());
        gettedCompany.setEmployees(company.getEmployees());

    }

    public void deleteCompany(Integer id) {
        companyList.remove(getCompanyByID(id));
    }
}
