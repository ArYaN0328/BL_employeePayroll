package com.example.employeepayroll.Service;


import com.example.employeepayroll.dto.EmployeeDto;
import com.example.employeepayroll.model.Employee;
import com.example.employeepayroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//UC1
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;
    public List<Employee> getAll()
    {
        return repository.findAll();
    }

    public Employee getbyId(Long id){
        return repository.findById(id).orElseThrow(()->new RuntimeException("Employee Not found"));
    }

    public Employee addEmployee(EmployeeDto employee){
        Employee emp=new Employee();
        emp.setSalary(employee.getSalary());
        emp.setDepartment(employee.getDepartment());
        emp.setName(employee.getName());
        return repository.save(emp);
    }

    public Employee updateEmployee(Long id,EmployeeDto emp)
    {
        Employee existed=getbyId(id);
        Employee emp2=new Employee();
        emp2.setName(emp.getName());
        existed.setName(emp2.getName());
        emp2.setDepartment(emp.getDepartment());
        existed.setDepartment(emp2.getDepartment());
        emp2.setSalary(emp.getSalary());
        existed.setSalary(emp2.getSalary());
        return repository.save(existed);
    }

    public void deleteByid(Long id)
    {
        repository.deleteById(id);
    }
}
