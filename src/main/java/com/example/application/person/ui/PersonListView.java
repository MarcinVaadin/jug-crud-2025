package com.example.application.person.ui;

import com.example.application.person.data.Person;
import com.example.application.person.data.PersonDataProvider;
import com.example.application.person.ui.component.PersonForm;
import com.example.application.person.ui.component.SearchField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.provider.ConfigurableFilterDataProvider;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.data.repository.CrudRepository;

@Route
@Menu(title = "Person", icon = "vaadin:group")
@RolesAllowed("ADMIN")
public class PersonListView extends VerticalLayout {

    // Inject data provider
    public PersonListView(CrudRepository<Person, Long> personRepository, PersonDataProvider personDataProvider) {

        add(new H2("Person List"));

        ConfigurableFilterDataProvider filteredDataProvider = personDataProvider.withConfigurableFilter();

        // add search field
        SearchField searchField = new SearchField();
        searchField.addValueChangeListener(e -> {
            filteredDataProvider.setFilter(e.getValue());
        });
        add(searchField);

        // add person form
        PersonForm personForm = new PersonForm();
        add(personForm);

        // add Save button
        Button saveButton = new Button("Create");
        add(saveButton);

        // add grid
        Grid<Person> grid = new Grid<>(Person.class);
        grid.setDataProvider(filteredDataProvider);
        grid.setColumns("id", "firstName", "lastName", "age", "email");
        add(grid);

        // create form binder (standard and validating)
        Binder<Person> binder = new BeanValidationBinder<>(Person.class);
        binder.bindInstanceFields(personForm);

        // load selected grid item into form
        grid.addSelectionListener(e -> {
            binder.setBean(e.getFirstSelectedItem().orElse(null));
            saveButton.setText(e.getFirstSelectedItem().isEmpty() ? "Create" : "Update");
        });

        // persist form on save
        saveButton.addClickListener(e -> {
            Person entity = grid.getSelectedItems().stream().findFirst().orElse(new Person());
            binder.writeBeanIfValid(entity);
            personRepository.save(entity);
            filteredDataProvider.refreshAll();
        });

        // add delete column
        grid.addComponentColumn((Person person) -> {
            Button deleteButton = new Button(VaadinIcon.TRASH.create());
            deleteButton.addClickListener(e -> {
                personRepository.delete(person);
                if (person.equals(binder.getBean())) {
                    binder.setBean(null);
                }
                filteredDataProvider.refreshAll();
            });
            return deleteButton;
        }).setKey("delete");

        // adjust columns width to fit content
        grid.getColumnByKey("id").setFlexGrow(0);
        grid.getColumnByKey("age").setFlexGrow(0);
        grid.getColumnByKey("delete").setFlexGrow(0);
    }

}
