package com.example.application.base.ui.component;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.dom.Style;

public class AppHeader extends Header {

    public AppHeader() {
        /// add application logo using VaadinIcon
        add(VaadinIcon.VAADIN_H.create());

        // add application name
        H1 title = new H1("Torun JUG Demo");
        title.getStyle().setFlexGrow("1");
        add(title);

        // navigate to main view on click
        addClickListener(event -> event.getSource().getUI().ifPresent(ui -> ui.navigate("")));

        // apply nicer styles
        setWidthFull();
        title.getStyle().setFontSize("1.5rem");
        getStyle().setDisplay(Style.Display.FLEX).setAlignItems(Style.AlignItems.CENTER).setGap("1rem")
                .setMarginRight("1rem");
    }

}
