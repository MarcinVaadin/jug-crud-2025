package com.example.application.base.ui;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@Route
@Menu(title = "Home", icon = "vaadin:home")
@PermitAll
public class MainView extends VerticalLayout {

    public MainView() {
        add(new H1("Hello Toruń!"));
        add(new Paragraph("Lorem ipsum"));
    }

}
