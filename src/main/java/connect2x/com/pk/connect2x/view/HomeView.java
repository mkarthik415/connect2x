package connect2x.com.pk.connect2x.view;

import com.vaadin.data.Property;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Responsive;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import javax.annotation.PostConstruct;

/**
 * Created by karthikmarupeddi on 7/25/15.
 */

@SpringView(name = HomeView.VIEW_NAME)
public class HomeView extends VerticalLayout implements View{

    public static final String VIEW_NAME = "HOME";
    private ComboBox processSelect;

    @PostConstruct
    void init() {

    }

    public HomeView(){
        setSizeFull();
        addStyleName("sales");
        addComponent(buildHeader());

    }

    private Component buildHeader() {
        HorizontalLayout header = new HorizontalLayout();
        header.addStyleName("transactions");
        header.setSpacing(true);
        Responsive.makeResponsive(header);

        Label titleLabel = new Label("Select Process type");
        titleLabel.setSizeUndefined();
        titleLabel.addStyleName(ValoTheme.LABEL_H1);
        titleLabel.addStyleName(ValoTheme.LABEL_NO_MARGIN);
        header.addComponents(titleLabel, buildToolbar());

        return header;
    }


    private Component buildToolbar() {
        HorizontalLayout toolbar = new HorizontalLayout();
        toolbar.addStyleName("toolbar");
        toolbar.setSpacing(true);

        processSelect = new ComboBox();
        processSelect.setItemCaptionPropertyId("title");
        processSelect.addItem("Job");
        processSelect.addShortcutListener(new ShortcutListener("Add",
                ShortcutAction.KeyCode.ENTER, null) {
            @Override
            public void handleAction(final Object sender, final Object target) {

            }
        });

        final Button add = new Button("Add");
        add.setEnabled(true);
        add.addStyleName(ValoTheme.BUTTON_PRIMARY);

        CssLayout group = new CssLayout(processSelect, add);
        group.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        toolbar.addComponent(group);

        processSelect.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(final Property.ValueChangeEvent event) {
                add.setEnabled(event.getProperty().getValue() != null);
            }
        });

        final Button clear = new Button("Clear");
        clear.addStyleName("clearbutton");
        clear.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
                clear.setEnabled(false);
            }
        });
        toolbar.addComponent(clear);

        add.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
                clear.setEnabled(true);
                getUI().addWindow(
                        new AddProcess());
            }
        });

        return toolbar;
    }

    /**
     * This view is navigated to.
     * <p/>
     * This method is always called before the view is shown on screen.
     * {@link ViewChangeEvent#getParameters() event.getParameters()} may contain
     * extra parameters relevant to the view.
     *
     * @param event ViewChangeEvent representing the view change that is
     *              occurring. {@link ViewChangeEvent#getNewView()
     *              event.getNewView()} returns <code>this</code>.
     */
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        System.out.println("enter homepage");

    }
}
