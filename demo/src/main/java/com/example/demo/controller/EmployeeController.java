package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.request.DeleteRequest;
import com.example.demo.request.SearchRequest;
import com.example.demo.service.FileUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



import org.springframework.util.StringUtils;



@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

   

    @GetMapping("/listEmployee")
    public String viewAll(Model model)
    { 
        List<Employee> employees = employeeRepository.getAll();
        model.addAttribute("employees", employees);
        model.addAttribute("pageTitle", "Home");
        return "listEmployee";
    }
    
    @GetMapping("/employee/{id}")
    public String viewDetail(@PathVariable("id") int id,Model model)
    {
        Employee employee = employeeRepository.getEmployee(id);
        model.addAttribute("employee",employee);
        return "employee";
    }

    @GetMapping("/employee/add")
    public String add(Model model) {
    model.addAttribute("employee", new Employee()); 
    model.addAttribute("pageTitle", "Add Employee");
    return "form";
    }

    @GetMapping(value = "/employee/edit/{id}")
    public String editBookId(@PathVariable("id") int id, Model model) {    
    Employee employee = employeeRepository.getEmployee(id);
    model.addAttribute("employee", employee);
    model.addAttribute("pageTitle", "Edit Employee");
    return "form";
}

    @PostMapping("/employee/save") 
    public String save(@Valid @ModelAttribute("employee") Employee employee, BindingResult result , @RequestParam("image") MultipartFile multipartFile) throws IOException {
    int id = employee.getId();
    if(id !=  0)
    {
        if (!multipartFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            employee.setPhoto(fileName);
            String uploadDir = "employee-photo" ;
            FileUpload.saveFile(uploadDir, fileName, multipartFile);
        }
        else
        {
            Employee e = employeeRepository.getEmployee(id);
            employee.setPhoto(e.getPhoto());
        }
        if(result.hasErrors())
        {
             return "form";
        }
        employeeRepository.updateByID(employee.getId(), employee);
    } else if(id == 0)
    {
        if (!multipartFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            employee.setPhoto(fileName);
            String uploadDir = "employee-photo" ;
            FileUpload.saveFile(uploadDir, fileName, multipartFile);
        }
        else
        {
            employee.setPhoto("default.jpg");
        }
        if(result.hasErrors())
        {
             return "form";
        }
         employeeRepository.addEmployee(employee);  
    }
    return "redirect:/listEmployee"; 
}

    @PostMapping(value = "/employee/delete")
    public String deleteByID(@ModelAttribute DeleteRequest request, BindingResult result) {
    if (!result.hasErrors()) {
       employeeRepository.deleteById(request.getId());
    }            
     return "redirect:/listEmployee"; 
   }  

   @GetMapping("/search")
   public String searchForm(Model model) { 
   model.addAttribute("searchrequest", new SearchRequest());   
   model.addAttribute("pageTitle", "Search Employee");
   return "search";
   }

   @GetMapping("/timkiem")
   public String timKiem(@RequestParam(value = "keyword") String keyword , Model model )
   {
     List<Employee> eList = employeeRepository.searchWithKeyword(keyword);
     model.addAttribute("employees",eList);         
     return "listEmployee";
   }

   @PostMapping("/employee/search")
   public String searchByKeyword(@ModelAttribute SearchRequest request, BindingResult bindingResult, Model model) {
   if (!bindingResult.hasFieldErrors()) {
      List<Employee> listSearch = employeeRepository.searchWithKeyword(request.getKeyword());
      model.addAttribute("employees", listSearch);
   }    
   return "listEmployee";
   }
}
    

