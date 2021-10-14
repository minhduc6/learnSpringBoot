package vn.techmaster.bookstore.repository;

import java.util.List;

import vn.techmaster.bookstore.exception.NotFoundException;
import vn.techmaster.bookstore.model.Book;

public class BookDao extends Dao<Book> {

  public BookDao() {
    collections.add(new Book(1, "Không gia đình", "Chú bé Remy lang thang theo gánh xiếc của bác Vitaly"));
    collections.add(new Book(2, "Cuốn theo chiều gió", "Nội chiến Hoa kỳ, cuộc tình giữa Red Butler và Ohara"));
  }

  @Override
  public List<Book> getAll() {
    return collections;
  }

  @Override
  public Book get(int id) {
    for (int i = 0; i < collections.size(); i++) {
         if (collections.get(i).getId() == id) {
           return collections.get(i);
         }
    }
     throw new NotFoundException("Khong ton tai book");
  }

  @Override
  public void add(Book t) {
    Book newBook = new Book();
    newBook.setId(collections.size() + 1);
    newBook.setTitle(t.getTitle());
    newBook.setDescription(t.getDescription());
    collections.add(newBook);
  }

  @Override
  public Book updateById(Book t , int id) {
    for (int i = 0; i < collections.size(); i++) {
      if (collections.get(i).getId() == id) {
        collections.get(i).setTitle(t.getTitle());
        collections.get(i).setDescription(t.getDescription());
        return collections.get(i);
      }
    }
    throw new NotFoundException("Không tồn tại Book ");
  }

  @Override
  public Book deleteByID(int id) {
    for (int i = 0; i < collections.size(); i++) {
      if (collections.get(i).getId() == id) {
        Book book = collections.remove(i);
        return book;
      }
    }
     throw new NotFoundException("Không tồn tại Book ");
  }

  
}