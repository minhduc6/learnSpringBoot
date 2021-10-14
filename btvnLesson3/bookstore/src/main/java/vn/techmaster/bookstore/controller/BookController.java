package vn.techmaster.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.techmaster.bookstore.model.Book;
import vn.techmaster.bookstore.repository.BookDao;

@Controller

public class BookController {
  @Autowired
  private BookDao bookDao;

  @GetMapping("book")
  public String listAll(Model model) {
    model.addAttribute("books", bookDao.getAll());
    return "allbooks";
  }
  
  @GetMapping("book/new")
  public String addBook(Model model)
  {
    Book book = new Book();
    model.addAttribute("book", book);
    model.addAttribute("pageTitle", "Create New Book");
    return "book_form";
  }

  @PostMapping("book/save")
  public String saveBook(Book book)
  {
    int id = book.getId();
    if (id == 0) {
      bookDao.add(book);
    }
    else if(id != 0)
    {
      bookDao.updateById(book, id);
    }
    return "redirect:/book";
  }

  @GetMapping("/book/edit/{id}")
  public String editBook(@PathVariable(name = "id") Integer id , Model model)
  {
    Book book = bookDao.get(id);
    model.addAttribute("book", book);
    model.addAttribute("pageTitle", "Edit Book ID : " + id);
    return "book_form";
  }
  
  @GetMapping("/book/delete/{id}")
  public String deleteBook(@PathVariable(name = "id") Integer id , Model model)
  {
    bookDao.deleteByID(id);
    return "redirect:/book";
  } 

  @GetMapping("/book/search")
  public String searchBook(@RequestParam(value = "id") Integer id , Model model)
  {
    Book book = bookDao.get(id);
    List<Book> books= new ArrayList<>();
    books.add(book);
    model.addAttribute("books", books);
    return "allbooks";
  }
}
