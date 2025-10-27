package com.example.application.person.ui;

import com.example.application.person.data.Person;
import com.example.application.person.data.PersonDataProvider;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO: register as view route

// TODO: add to menu

// TODO: setup view access to admin only

public class PersonListView { // TODO: make component from class

    // Autowired service and data provider
    public PersonListView(JpaRepository<Person, Long> repository, PersonDataProvider dataProvider) {

        // TODO: set view title in h2

        // TODO: wrap data provider with configurable filter

        // TODO: add search field

        // TODO: add person form

        // TODO: add Save button

        // TODO: add grid

        // TODO: create form binder (standard and validating), and bind person form

        // TODO: load selected grid item into form, update save button label to "Create" / "Update"

        // TODO: persist form on save, use new Person() for Create, existing entity for Update, write bean only if valid

        // TODO: add delete column, clear person form after delete if entity has been selected, set column key

        // TODO: adjust columns width to fit content (by keys)
    }

}
