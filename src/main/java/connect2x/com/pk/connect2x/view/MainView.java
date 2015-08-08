package connect2x.com.pk.connect2x.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by karthikmarupeddi on 7/18/15.
 */
@UIScope
public class MainView extends HorizontalLayout {


    @Autowired
    private SpringViewProvider viewProvider;

    public MainView() {
        setSizeFull();
        addStyleName("mainview");

        addComponent(new Connect2xMenu());

        ComponentContainer content = new CssLayout();
        content.addStyleName("view-content");
        content.setSizeFull();
        addComponent(content);
        setExpandRatio(content, 1.0f);


        Navigator navigator = new Navigator(getUI(), content);
        navigator.addProvider(viewProvider);
    }
}
