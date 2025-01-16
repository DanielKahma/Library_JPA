package org.example.library_jpa.entity;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDateTime regDate;

    @OneToOne
    @JoinColumn(name = "user_details_id")
    private Details userDetails;


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

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getRegDate() {
        return regDate;
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
