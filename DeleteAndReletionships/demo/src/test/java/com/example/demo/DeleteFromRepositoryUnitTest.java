package com.example.demo;


import com.example.demo.entity.Book;
import com.example.demo.entity.Category;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DeleteFromRepositoryUnitTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    Book book1;
    Book book2;
    List<Book> books;


    @PostConstruct
    public void initData() {
        Category category1 = new Category(1L, "anthology");
        categoryRepository.save(category1);
        Category category2 = new Category(2L, "comedy");
        categoryRepository.save(category2);
        book1 = new Book(1L, "The Hobbit", category1);
        book2 = new Book(2L, "Glory", category2);
        books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        bookRepository.saveAll(books);
    }


    @Test
    public void whenDeleteByIdFromRepository_thenDeletingShouldBeSuccessful() {
        bookRepository.deleteById(book1.getId());
        assertThat(bookRepository.count()).isEqualTo(1);
    }

    @Test
    public void whenDeleteAllFromRepository_thenRepositoryShouldBeEmpty() {
        bookRepository.deleteAll();
        assertThat(bookRepository.count()).isEqualTo(0);
    }

    @Test
    @Transactional
    public void whenDeleteFromDerivedQuery_thenDeletingShouldBeSuccessful() {
        long deletedRecords = bookRepository.deleteByTitle("The Hobbit");
        assertThat(deletedRecords).isEqualTo(1);
    }

    @Test
    @Transactional
    public void whenDeleteFromCustomQuery_thenDeletingShouldBeSuccessful() {
        bookRepository.deleteBooks("The Hobbit");
        assertThat(bookRepository.count()).isEqualTo(1);
    }

    @Test
    public void whenDeletingCategories_thenBooksShouldAlsoBeDeleted() {
        categoryRepository.deleteAll();
        assertThat(bookRepository.count()).isEqualTo(0);
        assertThat(categoryRepository.count()).isEqualTo(0);
    }

    @Test
    public void whenDeletingBooks_thenCategoriesShouldAlsoBeDeleted() {
        bookRepository.deleteAll();
        assertThat(bookRepository.count()).isEqualTo(0);
        assertThat(categoryRepository.count()).isEqualTo(2);
    }


}
