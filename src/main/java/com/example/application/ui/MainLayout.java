package com.example.application.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Layout;

import static com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import static com.vaadin.flow.theme.lumo.LumoUtility.Display;
import static com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import static com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import static com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import static com.vaadin.flow.theme.lumo.LumoUtility.Padding;

/**
 * <strong>Main layout for the application.</strong>
 * <p>
 * <a href=
 * "https://vaadin.com/docs/latest/building-apps/views/add-router-layout/flow#automatic-layouts">Layout</a>
 * explicitly marks this class as a default layout.
 * <a href="https://vaadin.com/docs/latest/components/app-layout">AppLayout</a>
 * is the easiest way to build a responsive application layout.
 * </p>
 */
@Layout
public class MainLayout extends AppLayout {

    public MainLayout() {
        // Menu will be added in next step
        addToDrawer(new Span("Navigation menu will go here"));

        // DrawerToggle is a button component that opens and closes the drawer
        addToNavbar(new DrawerToggle(), createHeader());
    }

    private Component createHeader() {
        // Vaadin has a built-in 2 icon sets - VaadinIcon and LumoIcon
        // https://vaadin.com/docs/latest/components/icons
        var appLogo = VaadinIcon.VAADIN_H.create();

        // com.vaadin.flow.component.html contains API for classic HTML components
        var appName = new Span("My App");
        // LumoUtility has CSS utility classes for styling
        appName.addClassNames(FontWeight.BOLD, FontSize.LARGE);

        var header = new Div(appLogo, appName);
        header.addClassNames(Display.FLEX, Padding.MEDIUM, Gap.MEDIUM, AlignItems.CENTER);
        return header;
    }

}
