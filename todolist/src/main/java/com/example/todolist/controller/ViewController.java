package com.example.todolist.controller;


import com.example.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @Autowired
    private TodoService todoService;
    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("todos",todoService.getTodos(""));
        return "index";
    }
}
