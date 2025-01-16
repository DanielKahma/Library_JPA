package org.example.library_jpa.repository;

import org.example.library_jpa.entity.Details;
import org.springframework.data.repository.CrudRepository;

public interface DetailsRepository extends CrudRepository<Details, Integer>{
    Details findByEmail(String email);

    Details findByNameContains(String name);

    Details findByNameIgnoreCase(String name);
}
