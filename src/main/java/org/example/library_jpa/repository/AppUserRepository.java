package org.example.library_jpa.repository;

import org.example.library_jpa.entity.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    Optional<AppUser> findByUsername(String username);

    AppUser findByRegDateBetween(LocalDateTime regDateAfter, LocalDateTime regDateBefore);

    AppUser findByUserDetailsId(Integer id);

    Optional<AppUser> findByUserDetailsEmailIgnoreCase(String email);

}
