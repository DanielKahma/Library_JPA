package org.example.library_jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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




}
