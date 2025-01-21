package org.example.library_jpa.repository;

import org.example.library_jpa.entity.Details;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DetailsRepository extends CrudRepository<Details, Integer>{
    List<Details> findByEmail(String email);

    List<Details> findByNameContains(String name);

    List<Details> findByNameIgnoreCase(String name);
}
