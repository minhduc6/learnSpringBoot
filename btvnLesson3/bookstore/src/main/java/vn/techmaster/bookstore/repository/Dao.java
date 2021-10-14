package vn.techmaster.bookstore.repository;

import java.util.List;
import java.util.ArrayList;

import vn.techmaster.bookstore.model.Book;

public abstract class Dao<T> {
  protected  List<T> collections = new ArrayList<>();

  public abstract List<T> getAll();

  public abstract Book get(int id);
 
  public abstract void add(T t);

  public abstract Book updateById(T t , int id);

  public abstract Book deleteByID(int id);

}