package com.example.application.ui.views;

import com.example.application.data.Person;
import com.example.application.data.PersonService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("person-list")
@PageTitle("Person List")
@Menu(title = "Person List", icon = "vaadin:group")
public class PersonListView extends VerticalLayout {

    public PersonListView(@Autowired PersonService personService) {

        add(new H2("Person List"));

        // Grid can generate column definitions automatically based on root-level
        // properties of the bean class
        Grid<Person> grid = new Grid<>(Person.class);
        // Set items collection to be displayed in the grid
        grid.setItems(personService.findAll());
        // Set columns explicitly to have desired order
        grid.setColumns("firstName", "lastName", "age", "email");
        add(grid);

    }
}
