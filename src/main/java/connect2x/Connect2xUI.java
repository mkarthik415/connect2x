package connect2x;

import com.vaadin.annotations.Theme;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import connect2x.com.pk.connect2x.view.Login;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;

/**
 * Created by karthikmarupeddi on 7/18/15.
 */
@Theme("valo")
@SpringUI
public class Connect2xUI extends UI {

    @Autowired
    private Login login;

    @Override
    protected void init(VaadinRequest request) {
        setLocale(Locale.US);
        Responsive.makeResponsive(this);
        addStyleName(ValoTheme.UI_WITH_MENU);
        updateContent();


    }

    private Button createNavigationButton(String caption, final String viewName) {
        Button button = new Button(caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        // If you didn't choose Java 8 when creating the project, convert this to an anonymous listener class
        button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));
        return button;
    }


    private void updateContent() {
        setContent(login);
        addStyleName("loginview");

    }
}