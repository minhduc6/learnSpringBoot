package com.example.employee.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.employee.entity.Employee;
import com.example.employee.request.DeleteRequest;
import com.example.employee.request.SearchRequest;
import com.example.employee.service.EmployeeService;

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

@Controller
public class EmployeeController {
   
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/list")
    public String homePage(Model model)
    {
        List<Employee> listEmployee = employeeService.getAll();
        model.addAttribute("employees", listEmployee);
        model.addAttribute("pageTitle", "Home");
        return "listEmployee";
    }

    @GetMapping("/employee/{id}")
    public String viewDetail(@PathVariable("id") int id,Model model)
    {
       try {
        Optional<Employee> employee = employeeService.getEmployee(id);
        model.addAttribute("employee",employee.get());
        return "employee";
       } catch (Exception e) {
             model.addAttribute("message", "Error in getting image");
             return "redirect:/";
       }
    }

    @GetMapping("/employee/add")
    public String add(Model model) {
    model.addAttribute("employee", new Employee()); 
    model.addAttribute("pageTitle", "Add Employee");
    return "form";
    }

    @GetMapping(value = "/employee/edit/{id}")
    public String editBookId(@PathVariable("id") int id, Model model)  {    
    Optional<Employee> employee = employeeService.getEmployee(id);
    model.addAttribute("employee", employee);
    model.addAttribute("pageTitle", "Edit Employee");
    return "form";
    }

    @PostMapping(value = "/employee/delete")
    public String deleteByID(@ModelAttribute DeleteRequest request, BindingResult result) {
    if (!result.hasErrors()) {
       employeeService.deleteById(request.getId());
    }            
     return "redirect:/list"; 
    }  

    
    @PostMapping("/employee/save") 
    public String save(@Valid Employee employee, BindingResult result , @RequestParam("image") MultipartFile multipartFile ,Model model) {
        try {
            if(multipartFile.isEmpty() == false){
            byte[] photo = multipartFile.getBytes();
            employee.setImage(photo);
            int saveEmployee = employeeService.add(employee);
            if (saveEmployee == 1) {
                return "redirect:/list"; 
            } 
            else
            {
                if(result.hasErrors())
            {
                 return "form";
            }
            }
            }
            else if(multipartFile.isEmpty())
            {
               if(employee.getId() != null) {
                    Optional<Employee> e =  employeeService.getEmployee(employee.getId());
                    if(e.isPresent())
                    { 
                           employee.setImage(e.get().getImage());
                           int saveEmployee = employeeService.add(employee);
                           if (saveEmployee == 1) {
                               return "redirect:/list"; 
                           } 
                           else
                           {
                               if(result.hasErrors())
                           {
                                return "form";
                           }
                           }
                    }
               }
               else
               {
                int saveEmployee = employeeService.add(employee);
                if (saveEmployee == 1) {
                    return "redirect:/list"; 
                } 
                else
                {
                    if(result.hasErrors())
                {
                     return "form";
                }
                }
               }
            }
           
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
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
     List<Employee> eList = employeeService.searchWithKeyword(keyword);
     model.addAttribute("employees",eList);         
     return "listEmployee";
   }

   @PostMapping("/employee/search")
   public String searchByKeyword(@ModelAttribute SearchRequest request, BindingResult bindingResult, Model model) {
   if (!bindingResult.hasFieldErrors()) {
      List<Employee> listSearch =  employeeService.searchWithKeyword(request.getKeyword());
      model.addAttribute("employees", listSearch);
   }    
   return "listEmployee";
   }

    


}
