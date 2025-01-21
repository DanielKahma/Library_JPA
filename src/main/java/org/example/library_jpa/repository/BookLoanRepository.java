package org.example.library_jpa.repository;

import jakarta.transaction.Transactional;
import org.example.library_jpa.entity.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface BookLoanRepository extends CrudRepository<BookLoan, Integer> {
    List<BookLoan> findByBorrowerId(Integer borrowerId);

    List<BookLoan> findByBookId(Integer BookId);

    List<BookLoan> findByReturnedIsFalse();

    List<BookLoan> findByDueDateBeforeAndReturnedIsFalse(LocalDate dueDate);

    List<BookLoan> findByLoanDate(LocalDate loanDate, LocalDate returnDate);

    @Modifying
    @Transactional
    @Query("UPDATE BookLoan b SET b.returned = true WHERE b.id = :loanId")
    void markAsReturned(@Param("loanId")int loanId);


}
