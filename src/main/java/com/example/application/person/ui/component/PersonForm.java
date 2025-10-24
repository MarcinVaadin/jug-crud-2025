package com.example.application.person.ui.component;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;

public class PersonForm extends FormLayout {

    private final TextField firstName = new TextField();

    private final TextField lastName = new TextField();

    private final EmailField email = new EmailField();

    private final IntegerField age = new IntegerField();

    public PersonForm() {
        addFormItem(firstName, "First name");
        addFormItem(lastName, "Last name");
        addFormItem(email, "Email");
        addFormItem(age, "Age");
    }

}
