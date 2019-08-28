package com.tw.apistackbase.entity;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int employeeID;
    private String gender;

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Employee(int employeeID, String gender) {
        this.employeeID = employeeID;
        this.gender = gender;
    }

    public Employee() {
    }

    public static List<Employee> getEmployee(){
        List<Employee> employeeList=new ArrayList<>();
        Employee employee=new Employee(001,"femal");
        Employee employee1=new Employee(002,"male");
        employeeList.add(employee);
        employeeList.add(employee1);
        return employeeList;
    }
}
