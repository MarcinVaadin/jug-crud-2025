package com.example.application.ui.views;

import com.example.application.data.Person;
import com.example.application.data.PersonDataProvider;
import com.example.application.data.PersonService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
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

    // Selection holder
    private Person currentPerson;

    // Detail form fields
    private TextField firstName = new TextField("First Name");
    private TextField lastName = new TextField("Last Name");
    private IntegerField age = new IntegerField("Age");
    private EmailField email = new EmailField("Email");

    // Form submit button
    private Button save = new Button("Save");

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

        // Binder binds form with model
        var binder = new Binder<>(Person.class);
        // Use current view fields (by name matching) as form fields
        binder.bindInstanceFields(this);

        // Add selection listener that will update binder bean
        grid.addSelectionListener(event -> {
            // Get selected item if present
            this.currentPerson = event.getFirstSelectedItem().orElse(null);
            // Set selection as binder bean to populate form fields
            binder.setBean(currentPerson);
        });

        // Save model on button click
        save.addClickListener(e -> {
            try {
                // If there is no selection, create new item
                if (this.currentPerson == null) {
                    this.currentPerson = new Person();
                }
                // Write form fields into model
                binder.writeBean(currentPerson);
                // Persist model
                personService.save(currentPerson);
                // Refresh data provider so grid can be updated
                personDataProvider.refreshAll();
            } catch (ValidationException ex) {
                // Here we will handle validation errors
                throw new RuntimeException(ex);
            }
        });

        add(createDetails());

    }

    // Create a TextField to be used as filter input
    public Component createFilterInputField(ConfigurableFilterDataProvider dataProvider) {
        var searchField = new TextField();
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

    // Create a form to show and allow edit details of the selected item
    private Component createDetails() {
        var layout = new VerticalLayout();
        layout.add(new H3("Person Details"));

        var formLayout = new HorizontalLayout();
        formLayout.add(firstName);
        formLayout.add(lastName);
        formLayout.add(age);
        formLayout.add(email);

        layout.add(formLayout, save);
        return layout;
    }
}
