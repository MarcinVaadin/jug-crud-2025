package com.example.application.ui.views;

import com.example.application.data.Person;
import com.example.application.data.PersonDataProvider;
import com.example.application.data.PersonService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ConfigurableFilterDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("person-list")
@PageTitle("Person List")
@Menu(title = "Person List", icon = "vaadin:group")
public class PersonListView extends VerticalLayout {

    // Inject data provider
    public PersonListView(@Autowired PersonService personService, @Autowired PersonDataProvider personDataProvider) {

        add(new H2("Person List"));

        // Wrap with filtered data provider to set filter
        ConfigurableFilterDataProvider configurableFilterDataProvider = personDataProvider.withConfigurableFilter();

        // Add Last Name filter field
        add(createFilterInputField(configurableFilterDataProvider));

        // Grid can generate column definitions automatically based on root-level
        // properties of the bean class
        Grid<Person> grid = new Grid<>(Person.class);
        // Use data provider instead of collection
        grid.setDataProvider(configurableFilterDataProvider);
        // Set columns explicitly to have desired order
        grid.setColumns("firstName", "lastName", "age", "email");
        add(grid);

    }

    // Create a TextField to be used as filter input
    public Component createFilterInputField(ConfigurableFilterDataProvider dataProvider) {
        TextField searchField = new TextField();
        searchField.setWidth("25%");
        searchField.setPlaceholder("Last name");
        searchField.setPrefixComponent(new Icon(VaadinIcon.SEARCH));
        // Use EAGER change mode to apply filter immediately
        searchField.setValueChangeMode(ValueChangeMode.EAGER);
        searchField.addValueChangeListener(e -> {
            // Update filter on data provider
            dataProvider.setFilter(e.getValue());
        });
        return searchField;
    }
}
