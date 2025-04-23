package com.example.application.ui.views;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("person-list")
@PageTitle("Person List")
@Menu(title = "Person List", icon = "vaadin:group")
public class PersonListView extends VerticalLayout {

    public PersonListView() {

        add(new H2("Person List"));

    }
}
