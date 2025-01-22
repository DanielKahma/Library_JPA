package org.example.library_jpa.repository;

import jakarta.transaction.Transactional;
import org.example.library_jpa.entity.Author;
import org.example.library_jpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findByFirstName(String firstName);
    List<Author> findByLastName(String lastName);
    List<Author> findByFirstNameContainingOrLastNameContaining(String keyword);
    List<Author> findByWrittenBooks_BookId(int bookId);
    @Modifying
    @Transactional
    @Query("UPDATE Author a SET a.firstName = :firstName, a.lastName = :lastName WHERE a.id = :Id")

    void deleteById(@Param("id") int id, @Param("firstName")String firstName, @Param("lastName")String lastName);


}
