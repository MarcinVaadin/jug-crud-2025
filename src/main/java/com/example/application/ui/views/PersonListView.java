package com.example.application.ui.views;

import com.example.application.data.PersonDataProvider;
import com.example.application.data.PersonService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ConfigurableFilterDataProvider;

public class PersonListView extends VerticalLayout {

    // Inject data provider
    public PersonListView(PersonService personService, PersonDataProvider personDataProvider) {

        add(new H2("Person List"));

        // add grid

        // add details form

    }

    public Component createFilterInputField(ConfigurableFilterDataProvider dataProvider) {
        var searchField = new TextField();
        searchField.setWidth("25%");
        searchField.setPlaceholder("Last name");
        searchField.setPrefixComponent(new Icon(VaadinIcon.SEARCH));

        // set filter on data provider on eager value change

        return searchField;
    }

    private Component createDetails() {
        var layout = new VerticalLayout();
        layout.add(new H3("Person Details"));

        var formFields = new HorizontalLayout();

        // add form inputs

        // add save button
        layout.add(formFields);
        return layout;
    }
}
