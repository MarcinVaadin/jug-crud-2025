package com.example.application.base.ui.component;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.server.menu.MenuEntry;

public class AppSideNav extends SideNav {

    public AppSideNav() {
        // TODO: Configure dynamic menu registration

    }

    // helper method for converting MenuEntry to SideNavItem
    private SideNavItem toSideNavItem(MenuEntry menuEntry) {
        var sideNavItem = new SideNavItem(menuEntry.title(), menuEntry.path());
        if (menuEntry.icon() != null) {
            sideNavItem.setPrefixComponent(new Icon(menuEntry.icon()));
        }
        return sideNavItem;
    }

}
