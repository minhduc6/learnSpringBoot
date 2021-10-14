package vn.techmaster.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.bookstore.model.Book;
import vn.techmaster.bookstore.repository.Dao;

@RestController
@RequestMapping("/api")
public class RestBookController {
       @Autowired
       private Dao<Book> repo;
       @GetMapping("/book")
       public ResponseEntity<?> listBook()
       {
              List<Book> result = repo.getAll();
              return ResponseEntity.ok().body(result);
       }

       @GetMapping("/book/{id}")
       public ResponseEntity<?> getBook(@PathVariable(name = "id") int id)
       {
              Book book = repo.get(id);
              return ResponseEntity.ok().body(book);
       }

       @PostMapping("/book/createBook")
       public ResponseEntity<?> createBook(@RequestBody Book book)
       {
              repo.add(book);
              return ResponseEntity.ok().body("Thêm Thành Công");
       }

       @PutMapping("/book/updateBook/{id}")
       public ResponseEntity<?> updateBook(@RequestBody Book book , @PathVariable(name = "id") int id)
       {
              Book result = repo.updateById(book, id);
              System.out.println("Update Thành Công");
              return ResponseEntity.ok().body(result);
       }

       @DeleteMapping("/book/deleteBook/{id}")
       public ResponseEntity<?> deleteBook(@PathVariable(name = "id") int id)
       {
              Book result = repo.deleteByID(id);
              return ResponseEntity.ok().body(result);
       }
}
