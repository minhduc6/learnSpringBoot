package com.example.demo.repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Employee;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

@Repository
public class EmployeeRepoImple implements EmployeeRepository {

    public List<Employee> emList = new ArrayList<>();

    public EmployeeRepoImple() {
        readCSV("employee.csv");
    }

    @Override
    public void readCSV(String CsvFile) {
        try {
            File file = ResourceUtils.getFile("classpath:static/" + CsvFile);
            CsvMapper mapper = new CsvMapper(); // Dùng để ánh xạ cột trong CSV với từng trường trong POJO
            CsvSchema schema = CsvSchema.emptySchema().withHeader().withColumnSeparator(','); // Dòng đầu tiên sử dụng làm Header
            ObjectReader oReader = mapper.readerFor(Employee.class).with(schema); // Cấu hình bộ đọc CSV phù hợp với kiểu
            Reader reader = new FileReader(file);
            MappingIterator<Employee> mi = oReader.readValues(reader); // Iterator đọc từng dòng trong file
            while (mi.hasNext()) {
              Employee employee = mi.next();
              addEmployee(employee);
            }
          }catch (IOException e) {
            System.out.println(e);   
          }
    }

    @Override
    public void addEmployee(Employee e) {
        Employee newEmployee = new Employee();
        newEmployee.setId(emList.size() + 1);
        newEmployee.setFirstName(e.getFirstName());
        newEmployee.setLastName(e.getLastName());
        newEmployee.setEmailId(e.getEmailId());
        newEmployee.setPassportNumber(e.getPassportNumber());
        emList.add(newEmployee); 
    }

    @Override
    public List<Employee> getAll() {
        return emList;
    }

    @Override
    public Employee getEmployee(int id) {
        for (int i = 0; i < emList.size(); i++) {
            if(emList.get(i).getId() == id)
            {
                 return emList.get(i);
            }
        }
        throw new NotFoundException("Khong co Employee");
    }

    @Override
    public Employee updateByID(int id, Employee e) {
        for (int i = 0; i < emList.size(); i++) {
            if(emList.get(i).getId() == id)
            {
                emList.get(i).setLastName(e.getLastName());
                emList.get(i).setLastName(e.getLastName());
                emList.get(i).setEmailId(e.getEmailId());
                emList.get(i).setPassportNumber(e.getPassportNumber());
                return emList.get(i);
            }
        }
        throw new NotFoundException("Khong co Employee");
    }

    @Override
    public Employee deleteById(int id) {
        for (int i = 0; i < emList.size() ; i++) {
            if(emList.get(i).getId() == id)
            {
               Employee e = emList.remove(i);
               return e;
            }
        }
        throw new NotFoundException("Khong co Employee");
    }

    @Override
    public List<Employee> searchWithKeyword(String keyword) {
        return emList
        .stream()
        .filter(employee -> employee.matchWithKeyWord(keyword))
        .collect(Collectors.toList());
    }
    
}
