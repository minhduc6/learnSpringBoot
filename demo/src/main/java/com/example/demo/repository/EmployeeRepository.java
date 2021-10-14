package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Employee;

import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepository {
    
    public void readCSV(String CsvFile);

    public  void addEmployee(Employee e);

    public  List<Employee>  getAll();

    public Employee getEmployee(int id);

    public Employee updateByID(int id , Employee e);

    public Employee deleteById(int id);
    
    public List<Employee> searchWithKeyword(String keyword);

}
