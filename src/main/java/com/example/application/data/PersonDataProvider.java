package com.example.application.data;

import com.vaadin.flow.data.provider.AbstractBackEndDataProvider;
import com.vaadin.flow.data.provider.Query;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class PersonDataProvider extends AbstractBackEndDataProvider<Person, String> {

    private PersonRepository personRepository;

    public PersonDataProvider(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    protected Stream<Person> fetchFromBackEnd(Query<Person, String> query) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    protected int sizeInBackEnd(Query<Person, String> query) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private Pageable toPageable(Query<Person, String> query) {
        // Skipping sorting for easiness of demo
        return PageRequest.of(query.getPage(), query.getPageSize());
    }

}
