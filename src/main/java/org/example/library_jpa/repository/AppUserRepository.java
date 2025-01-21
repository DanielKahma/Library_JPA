package org.example.library_jpa.repository;

import org.example.library_jpa.entity.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    Optional<AppUser> findByUsername(String username);

    List<AppUser> findByRegDateBetween(LocalDateTime regDateAfter, LocalDateTime regDateBefore);

    List<AppUser> findByUserDetailsId(Integer id);

    Optional<AppUser> findByUserDetailsEmailIgnoreCase(String email);

}
