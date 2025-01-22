package org.example.library_jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.config.ConfigDataLocationNotFoundException;

import java.util.List;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(updatable = false, nullable = false)
    private String isbn;

    @Column(updatable = false, nullable = false)
    private String Title;

    @Column(nullable = false)
    private int maxLoanDays;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    public Book(Integer id, String isbn, String title, int maxLoanDays, List<Author> authors) {
        this.id = id;
        this.isbn = isbn;
        Title = title;
        this.maxLoanDays = maxLoanDays;
        this.authors = authors;
    }

    public Book(String isbn, String title, int maxLoanDays, List<Author> authors) {
        this.isbn = isbn;
        Title = title;
        this.maxLoanDays = maxLoanDays;
        this.authors = authors;
    }

    public Book() {

    }
}
