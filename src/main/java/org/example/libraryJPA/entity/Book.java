package org.example.libraryJPA.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity
@Getter
@Setter
public class Book {
    @Setter
    @jakarta.persistence.Id
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

    public void addAuthor(Author author) {
        if (author != null && authors != null) {
            authors.add(author);
        }
        else {
            try{
                throw new IllegalArgumentException("authors cannot be null" );
            }
            catch (IllegalArgumentException e){
                throw new IllegalArgumentException("authors cannot be null" );
            }
        }
    }

    public void removeAuthor(Author author) {
        if (author != null && authors != null) {
            authors.remove(author);
        }
        else {
            try {
                throw new IllegalArgumentException("authors cannot be null");
            }
            catch (IllegalArgumentException e){
                throw new IllegalArgumentException("authors cannot be null" );
            }
        }
    }

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

    public Long getId(Long id) {
        return id;
    }
}
