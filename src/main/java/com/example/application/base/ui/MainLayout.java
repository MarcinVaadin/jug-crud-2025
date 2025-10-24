package com.example.application.base.ui;

import com.example.application.base.ui.component.AppHeader;
import com.example.application.base.ui.component.AppSideNav;
import com.example.application.base.ui.component.LoginButton;
import com.example.application.security.SecurityService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Layout
@AnonymousAllowed
public class MainLayout extends AppLayout {

    public MainLayout(SecurityService securityService) {

        // add side nav to the drawer
        addToDrawer(new AppSideNav());

        // include drawer toggle and header in navbar
        AppHeader appHeader = new AppHeader();
        addToNavbar(new DrawerToggle(), appHeader);

        // add login / logout buttons
        appHeader.add(new LoginButton(securityService));
    }

}
