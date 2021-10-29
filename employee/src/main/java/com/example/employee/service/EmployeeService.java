package com.example.employee.service;

import com.example.employee.entity.Employee;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
     
     public List<Employee> getAll();

     public Optional<Employee> getEmployee(int id);

     public int add(Employee e);

     public void updateById (int id);

     public void deleteById(int id);
     
     public List<Employee> searchWithKeyword(String keyword);
    
}
