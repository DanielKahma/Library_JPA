package org.example.library_jpa.repository;

import org.example.library_jpa.entity.AppUser;
import org.example.library_jpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface BookRepository extends CrudRepository <Book, Integer> {
    List<Book> findByIsbnIgnoreCase(String isbn);
    List<Book> findByTitleContains(String title);
    List<Book> findByMaxLoanDaysLessThan(int MaxLoanDays);

}
