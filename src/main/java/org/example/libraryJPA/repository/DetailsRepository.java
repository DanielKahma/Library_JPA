package org.example.libraryJPA.repository;

import org.example.libraryJPA.entity.Details;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DetailsRepository extends CrudRepository<Details, Integer>{
    List<Details> findByEmail(String email);

    List<Details> findByNameContains(String name);

    List<Details> findByNameIgnoreCase(String name);
}
