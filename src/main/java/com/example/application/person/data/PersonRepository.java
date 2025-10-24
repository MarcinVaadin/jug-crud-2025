package com.example.application.person.data;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Basic Spring JPA repository implementation.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByLastNameContainingIgnoreCase(String lastName, Pageable pageable);

    long countByLastNameContainingIgnoreCase(String lastName);

}
