package connect2x.com.pk.connect2x.view;

import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by karthikmarupeddi on 8/1/15.
 */
public class AddProcess extends Window {

    private final TextField nameField = new TextField("Name");

    public AddProcess() {
        setCaption("Edit Dashboard");
        setModal(true);
        setClosable(false);
        setResizable(false);
        setWidth(500.0f, Unit.PIXELS);

        addStyleName("edit-dashboard");
        setContent(buildContent("Testing"));
    }

    private Component buildContent(final String currentName) {
        VerticalLayout result = new VerticalLayout();
        result.setMargin(true);
        result.setSpacing(true);

        nameField.setValue(currentName);
        nameField.addStyleName("caption-on-left");
        nameField.focus();

        result.addComponent(nameField);
        result.addComponent(buildFooter());

        return result;
    }

    private Component buildFooter() {
        HorizontalLayout footer = new HorizontalLayout();
        footer.setSpacing(true);
        footer.addStyleName(ValoTheme.WINDOW_BOTTOM_TOOLBAR);
        footer.setWidth(100.0f, Unit.PERCENTAGE);

        Button cancel = new Button("Cancel");
        cancel.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
                close();
            }
        });
        cancel.setClickShortcut(ShortcutAction.KeyCode.ESCAPE, null);

        Button save = new Button("Save");
        save.addStyleName(ValoTheme.BUTTON_PRIMARY);
        save.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
               // listener.dashboardNameEdited(nameField.getValue());
                close();
            }
        });
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER, null);

        footer.addComponents(cancel, save);
        footer.setExpandRatio(cancel, 1);
        footer.setComponentAlignment(cancel, Alignment.TOP_RIGHT);
        return footer;
    }
}
