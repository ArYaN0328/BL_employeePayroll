package com.example.employeepayroll.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private String name;
    private String department;
    private double salary;

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

}
