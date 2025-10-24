package com.example.application.person.ui.component;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;

public class SearchField extends TextField {

    public SearchField() {
        setWidth("25%");
        setPlaceholder("Last name");
        setPrefixComponent(new Icon(VaadinIcon.SEARCH));
        // commit value after each key press
        setValueChangeMode(ValueChangeMode.EAGER);
    }

}
