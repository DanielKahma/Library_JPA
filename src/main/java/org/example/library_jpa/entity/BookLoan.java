package org.example.library_jpa.entity;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(updatable = false, nullable = false)
    private LocalDate loanDate;

    @Column(nullable = false)
    private LocalDate dueDate;

    @Column(nullable = false)
    private boolean returned;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "appuser_id")
    private AppUser borrower;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "book_id")
    private Book book;


    public BookLoan(Integer id, LocalDate loanDate, LocalDate dueDate, AppUser borrower, Book book) {
        this.id = id;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.borrower = borrower;
        this.book = book;
    }
    public BookLoan() {

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookLoan bookLoan = (BookLoan) o;
        return returned == bookLoan.returned && Objects.equals(id, bookLoan.id) && Objects.equals(loanDate, bookLoan.loanDate) && Objects.equals(dueDate, bookLoan.dueDate) && Objects.equals(borrower, bookLoan.borrower) && Objects.equals(book, bookLoan.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loanDate, dueDate, returned, borrower, book);
    }

    @Override
    public String toString() {
        return "BookLoan{" +
                "id=" + id +
                ", loanDate=" + loanDate +
                ", dueDate=" + dueDate +
                ", returned=" + returned +
                ", borrower=" + borrower +
                ", book=" + book +
                '}';
    }
}
