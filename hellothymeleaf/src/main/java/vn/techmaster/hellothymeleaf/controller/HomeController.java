package vn.techmaster.hellothymeleaf.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.techmaster.hellothymeleaf.model.Book;
import vn.techmaster.hellothymeleaf.model.Student;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
  @GetMapping
  public String homePage() {
    return "index";
  }

  @GetMapping(value="/json", produces = "application/json")
  @ResponseBody
  public Book returnBook() {
    return new Book("De men phieu luu ky", "To Hoai");
  }
  @GetMapping(value="/xml", produces = MediaType.APPLICATION_XML_VALUE)
  @ResponseBody
  public Book returnBookXML() {
    return new Book("De men phieu luu ky", "To Hoai");
  }
  @GetMapping(value="/book")
  public String returnBookHTML(Model model) {
    Book book = new Book("De men phieu luu ky", "To Hoai");

    model.addAttribute("book",book);
    model.addAttribute("student",new Student("John",9));
    return "book";
  }
  @GetMapping("/students")
  public String students(Model model){
    List<Student>  listStudent = new ArrayList<>();
    listStudent.add(new Student("John",9));
    listStudent.add(new Student("KKK",9));
    listStudent.add(new Student("AAA",9));
    model.addAttribute("students",listStudent);
    model.addAttribute("messenger","<h1>Student</h1>");
    return "students";
  }
}
