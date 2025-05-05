package com.example.application.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.server.menu.MenuEntry;

public class MainLayout {

    public MainLayout() {

        // add side nav to the drawer

        // include drawer toggle and header in navbar

        // add login / logout buttons

    }

    private Component createHeader() {
        /// add application logo using VaadinIcon

        // navigate to main view on logo click

        // add application name

        var header = new HorizontalLayout(); // add logo and app name in horizontal layout
        return header;
    }

    private SideNav createSideNav() {
        var sideNav = new SideNav();

        // dynamic menu registration

        return sideNav;
    }

    private SideNavItem toSideNavItem(MenuEntry menuEntry) {
        var sideNavItem = new SideNavItem(menuEntry.title(), menuEntry.path());
        sideNavItem.setPrefixComponent(new Icon(menuEntry.icon()));
        return sideNavItem;
    }

//    private Component createLoginButton(SecurityService securityService) {
//        var authUser = securityService.getAuthenticatedUser();
//        if (authUser != null) {
//            return new Button("Logout " + authUser.getUsername(), ev -> securityService.logout());
//        } else {
//            return new Button("Login", ev -> getUI().ifPresent(ui -> ui.navigate("login")));
//        }
//    }

}
