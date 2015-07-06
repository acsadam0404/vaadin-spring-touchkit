package org.vaadin.tkspring;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.vaadin.viritin.label.RichText;
import com.vaadin.addon.touchkit.ui.NavigationManager;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Switch;
import com.vaadin.annotations.Widgetset;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import org.vaadin.viritin.layouts.MVerticalLayout;

@Theme("touchkit")
@SpringUI
// If not using cdn.virit.in, uncomment following annotation and vaadin plugin
// from pom.xml
//@Widgetset("AppWidgetset")
public class MainUI extends UI {

    @Override
    protected void init(VaadinRequest request) {

        NavigationManager navigationManager = new NavigationManager();
        NavigationView view = new NavigationView("Hello TouchKit!");
        final Switch aSwitch = new Switch("Yes no");

        view.setContent(new MVerticalLayout(
                new RichText(
                        "Vaadin *TouchKit* with Vaadin *Spring* with Spring *Boot*."),
                aSwitch,
                new Button("Holaa!", e -> Notification.show("You touched it!"))
        ));

        navigationManager.navigateTo(view);

        setContent(
                navigationManager
        );
    }
}
