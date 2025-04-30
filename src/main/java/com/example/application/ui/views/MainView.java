package com.example.application.ui.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

/**
 * <strong>Main (default) view</strong>
 * <p>
 * <a href="https://vaadin.com/docs/latest/flow/routing/route">Route</a> marks
 * this view as default application view.
 * </p>
 */
@Route
@Menu(title = "Hello", order = 1, icon = "vaadin:comment-o") // add to menu for clarity
@PermitAll // allows logged-in users to access this view
public class MainView extends VerticalLayout { // each Vaadin view is a component

    public MainView() {
        // com.vaadin.flow.component.html contains API for classic HTML components
        add(new H1("Hello JUG!"));

        add(new Paragraph("Some text here"));
    }

}
