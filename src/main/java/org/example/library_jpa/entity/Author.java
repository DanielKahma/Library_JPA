package org.example.library_jpa.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @ManyToMany(
            cascade = {CascadeType.ALL}, mappedBy = "authors"
    )
    private Set<Book> writtenBooks;
    public void addBook(Book writtenBook) {
        if (writtenBooks != null) {
            writtenBooks.add(writtenBook);
        }
        else {
            try{
                throw new IllegalArgumentException("book cannot be null");
            }
            catch(IllegalArgumentException e){
                throw new IllegalArgumentException("book cannot be null");
            }
        }
    }

    public void removeBook(Book writtenBook) {
        if (writtenBooks != null) {
            writtenBooks.remove(writtenBook);
        }
        else {
            try{
                throw new IllegalArgumentException("book cannot be null");
            }
            catch(IllegalArgumentException e){
                throw new IllegalArgumentException("book cannot be null");
            }
        }
    }

    public Author() {
    }

    public Author(String firstName, String lastName, Set<Book> writtenBooks, Integer id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.writtenBooks = writtenBooks;
        this.id = id;
    }

    public Author(String firstName, String lastName, Set<Book> writtenBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.writtenBooks = writtenBooks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getWrittenBooks() {
        return writtenBooks;
    }

    public void setWrittenBooks(Set<Book> writtenBooks) {
        this.writtenBooks = writtenBooks;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(firstName, author.firstName) && Objects.equals(lastName, author.lastName) && Objects.equals(writtenBooks, author.writtenBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, writtenBooks);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", writtenBooks=" + writtenBooks +
                '}';
    }
}
