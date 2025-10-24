package com.example.application.person.ui.component;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextField;

/**
 * Simple extension of TextField with placeholder and icon
 */
public class SearchField extends TextField {

    public SearchField() {
        setWidth("25%");
        setPlaceholder("Last name");
        setPrefixComponent(new Icon(VaadinIcon.SEARCH));

        // TODO: commit value after each key press

    }

}
