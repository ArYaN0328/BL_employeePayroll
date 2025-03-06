package com.example.employeepayroll.Service;


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

    public Employee addEmployee(Employee employee){
        return repository.save(employee);
    }

    public Employee updateEmployee(Long id,Employee emp)
    {
        Employee existed=getbyId(id);
        existed.setName(emp.getName());
        existed.setDepartment(emp.getDepartment());
        existed.setSalary(emp.getSalary());
        return repository.save(existed);
    }

    public void deleteByid(Long id)
    {
        repository.deleteById(id);
    }
}
