package org.example.library_jpa.repository;

import org.example.library_jpa.entity.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface BookLoanRepository extends CrudRepository<BookLoan, Integer> {
    List<BookLoan> findByBorrowerId(Integer borrowerId);

    List<BookLoan> findByBookId(Integer BookId);

    List<BookLoan> findByReturnedIsFalse();

    List<BookLoan> findByDueDateBeforeAndReturnedIsFalse(LocalDate dueDate);

    List<BookLoan> findByLoanDate(LocalDate loanDate, LocalDate returnDate);

    void markAsReturned(Integer loanId);


}
