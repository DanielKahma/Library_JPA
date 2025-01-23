package org.example.library_jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class AppUser {
    @Getter
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Column(unique = true, nullable = false)
    private String username;

    @Getter
    @Column(nullable = false)
    private String password;

    @Getter
    @Column(nullable = false)
    private LocalDateTime regDate;

    @OneToOne
    @JoinColumn(name = "user_details_id")
    private Details userDetails;

    @OneToMany(
            cascade = CascadeType.ALL, mappedBy = "borrower"
    )
    private List<BookLoan> loans;


    public AppUser(Integer id, String username, String password, LocalDateTime regDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.regDate = regDate;
    }

    public AppUser(String username, String password, LocalDateTime regDate) {
        this.username = username;
        this.password = password;
        this.regDate = regDate;

    }

    public AppUser() {

    }

    public Details getUserDetail() {
        return userDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(id, appUser.id) && Objects.equals(username, appUser.username) && Objects.equals(password, appUser.password) && Objects.equals(regDate, appUser.regDate) && Objects.equals(userDetails, appUser.userDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, regDate, userDetails);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", regDate=" + regDate +
                ", userDetails=" + userDetails +
                '}';
    }
}
