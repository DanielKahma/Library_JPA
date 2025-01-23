package org.example.libraryJPA.repository;

import org.example.libraryJPA.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository <Book, Integer> {
    List<Book> findByIsbnIgnoreCase(String isbn);
    List<Book> findByTitleContains(String title);
    List<Book> findByMaxLoanDaysLessThan(int MaxLoanDays);

}
