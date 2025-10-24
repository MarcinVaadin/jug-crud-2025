package com.example.application.person.data;

import com.vaadin.flow.data.provider.AbstractBackEndDataProvider;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.SortDirection;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PersonDataProvider extends AbstractBackEndDataProvider<Person, String> {

    private final PersonRepository personRepository;

    public PersonDataProvider(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Query<MODEL, FILTER> => Person model and String last name filter
    @Override
    protected Stream<Person> fetchFromBackEnd(Query<Person, String> query) {
        if (query.getFilter().isPresent()) {
            return personRepository.findByLastNameContainingIgnoreCase(query.getFilter().get(), toPageable(query))
                    .stream();
        }
        return personRepository.findAll(toPageable(query)).stream();
    }

    @Override
    protected int sizeInBackEnd(Query<Person, String> query) {
        if (query.getFilter().isPresent()) {
            return (int) personRepository.countByLastNameContainingIgnoreCase(query.getFilter().get());
        }
        return (int) personRepository.count();
    }

    private Pageable toPageable(Query<Person, String> query) {
        List<Sort.Order> orders = new ArrayList<>();
        for (QuerySortOrder sortOrder : query.getSortOrders()) {
            Sort.Direction direction = sortOrder.getDirection().compareTo(SortDirection.ASCENDING) == 0
                    ? Sort.Direction.ASC
                    : Sort.Direction.DESC;
            orders.add(new Sort.Order(direction, sortOrder.getSorted()));
        }
        return PageRequest.of(query.getPage(), query.getPageSize()).withSort(Sort.by(orders));
    }

}
