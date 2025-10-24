package com.example.application.base.ui.component;

import com.vaadin.flow.component.button.Button;

public class LoginButton extends Button {

    // TODO: Uncomment when enabling security
//    public LoginButton(SecurityService securityService) {
//        var authUser = securityService.getAuthenticatedUser();
//        if (authUser != null) {
//            setText("Logout " + authUser.getUsername());
//            addClickListener(ev -> securityService.logout());
//        } else {
//            setText("Login");
//            addClickListener(ev -> getUI().ifPresent(ui -> ui.navigate("login")));
//        }
//    }

}
