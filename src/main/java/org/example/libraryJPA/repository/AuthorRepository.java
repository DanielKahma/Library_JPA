package org.example.libraryJPA.repository;

import jakarta.transaction.Transactional;
import org.example.libraryJPA.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findByFirstName(String firstName);

    List<Author> findByLastName(String lastName);

    @Query("SELECT a FROM Author a WHERE a.firstName like %:keyword% OR a.lastName LIKE %:keyword%")
    List<Author> findByFirstNameContainingOrLastNameContaining(@Param("keyword") String keyword2);

    List<Author> findByWrittenBooks_BookId(int bookId);

    @Modifying
    @Transactional
    @Query("UPDATE Author a SET a.firstName = :firstName, a.lastName = :lastName WHERE a.id = :Id")

    void deleteById(@Param("id") int id, @Param("firstName")String firstName, @Param("lastName")String lastName);


}
