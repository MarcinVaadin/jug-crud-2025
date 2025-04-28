package com.example.application.data;

import com.vaadin.flow.data.provider.AbstractBackEndDataProvider;
import com.vaadin.flow.data.provider.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * Data provider for the Person entity. This class extends
 * AbstractBackEndDataProvider to provide data from the backend.
 */
@Service
public class PersonDataProvider extends AbstractBackEndDataProvider<Person, String> {

    private PersonRepository personRepository;

    public PersonDataProvider(@Autowired PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    protected Stream<Person> fetchFromBackEnd(Query<Person, String> query) {
        if (query.getFilter().isEmpty()) {
            return personRepository.findAll(toPageable(query)).stream();
        }
        return personRepository.findByLastNameContainingIgnoreCase(query.getFilter().get(), toPageable(query)).stream();
    }

    @Override
    protected int sizeInBackEnd(Query<Person, String> query) {
        if (query.getFilter().isEmpty()) {
            return (int) personRepository.count();
        }
        return (int) personRepository.countByLastNameContainingIgnoreCase(query.getFilter().get());
    }

    private Pageable toPageable(Query<Person, String> query) {
        // Skipping sorting for easiness of demo
        return PageRequest.of(query.getPage(), query.getPageSize());
    }

}
