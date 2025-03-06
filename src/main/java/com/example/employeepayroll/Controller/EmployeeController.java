package com.example.employeepayroll.Controller;


import com.example.employeepayroll.Service.EmployeeService;
import com.example.employeepayroll.dto.EmployeeDto;
import com.example.employeepayroll.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//UC2
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    EmployeeService empservice;

    @GetMapping
    public List<Employee> getall()
    {
        return empservice.getAll();
    }
    @GetMapping("/{id}")
    public Employee getbyid(@PathVariable Long id)
    {
        return empservice.getbyId(id);
    }
    @PostMapping
    public Employee posting(@RequestBody EmployeeDto emp)
    {
       return empservice.addEmployee(emp);

    }
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employee) {
        return empservice.updateEmployee(id, employee);
    }
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        empservice.deleteByid(id);
        return "Employee Deleted Successfully";
    }



}
