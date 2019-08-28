package com.tw.apistackbase.entity;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private int companyID;
    private List<Employee> employees;

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public List<Employee> getEmployees() {
        List<Employee> employeeList=new ArrayList<>();
        employeeList.addAll(employees);
        return employeeList;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Company() {
    }

    public Company(int companyID, List<Employee> employees) {
        this.companyID = companyID;
        this.employees = employees;
    }

    public static List<Company> companyData(){
        List companyList=new ArrayList();
        List<Employee> employeeList = Employee.getEmployee();
        Company company=new Company(1,employeeList);
        Company company1=new Company(2,employeeList);
        companyList.add(company);
        companyList.add(company1);
        return companyList;
    }
}
