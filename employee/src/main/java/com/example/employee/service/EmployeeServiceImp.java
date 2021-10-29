package com.example.employee.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp  implements EmployeeService{
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> getEmployee(int id) {
        return employeeRepo.findById(id);
    }

    @Override
    public int add(Employee e) {
        try {
            employeeRepo.save(e);
            return 1;
        } catch (Exception ex) {
            return 0;
        }
    }

    @Override
    public void updateById(int id) {
        
    }

    @Override
    public void deleteById(int id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public List<Employee> searchWithKeyword(String keyword) {
        return employeeRepo.findAll().stream()
        .filter(employee -> employee.matchWithKeyWord(keyword))
        .collect(Collectors.toList());
    }
    
}
