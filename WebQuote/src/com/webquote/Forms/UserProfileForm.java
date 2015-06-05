package com.webquote.Forms;

import com.vaadin.data.Property.ReadOnlyException;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.UserError;
import com.vaadin.shared.Position;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.webquote.Dao.CountryDao;
import com.webquote.Dao.UserDao;
import com.webquote.Dao.UserGroupDao;
import com.webquote.EntityClasses.User;

public class UserProfileForm extends Window{
	
	 private final BeanFieldGroup<User> fieldGroup;
	    /*
	     * Fields for editing the User object are defined here as class members.
	     * They are later bound to a FieldGroup by calling
	     * fieldGroup.bindMemberFields(this). The Fields' values don't need to be
	     * explicitly set, calling fieldGroup.setItemDataSource(user) synchronizes
	     * the fields with the user object.
	     */
	    @PropertyId("firstName")
	    private TextField firstNameField;
	    @PropertyId("lastName")
	    private TextField lastNameField;
	    @PropertyId("email")
	    private TextField emailField;
	    @PropertyId("userCode")
	    private TextField userCode;
	    private TextField country;
	    private TextField group;
	    public User userUI;

	    private UserProfileForm(final User user,final boolean preferencesTabOpen) {
	    	userUI=user;
	    	
	    	addStyleName("profile-window");
	        Responsive.makeResponsive(this);

	        setModal(true);
	        setCloseShortcut(KeyCode.ESCAPE, null);
	        setResizable(false);
	        setClosable(false);
	        setHeight(90.0f, Unit.PERCENTAGE);

	        VerticalLayout content = new VerticalLayout();
	        content.setSizeFull();
	        content.setMargin(new MarginInfo(true, false, false, false));
	        setContent(content);

	        TabSheet detailsWrapper = new TabSheet();
	        detailsWrapper.setSizeFull();
	        detailsWrapper.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
	        detailsWrapper.addStyleName(ValoTheme.TABSHEET_ICONS_ON_TOP);
	        detailsWrapper.addStyleName(ValoTheme.TABSHEET_CENTERED_TABS);
	        content.addComponent(detailsWrapper);
	        content.setExpandRatio(detailsWrapper, 1f);

	        detailsWrapper.addComponent(buildProfileTab());
	        detailsWrapper.addComponent(buildPreferencesTab());

	        if (preferencesTabOpen) {
	            detailsWrapper.setSelectedTab(1);
	        }

	        content.addComponent(buildFooter());

	        fieldGroup = new BeanFieldGroup<User>(User.class);
	        fieldGroup.bindMemberFields(this);
	        fieldGroup.setItemDataSource(user);
	    }

	    private Component buildPreferencesTab() {
	        VerticalLayout root = new VerticalLayout();
	        root.setCaption("Preferences");
	        root.setIcon(FontAwesome.COGS);
	        root.setSpacing(true);
	        root.setMargin(true);
	        root.setSizeFull();

	        Label message = new Label("Not implemented in this demo");
	        message.setSizeUndefined();
	        message.addStyleName(ValoTheme.LABEL_LIGHT);
	        root.addComponent(message);
	        root.setComponentAlignment(message, Alignment.MIDDLE_CENTER);

	        return root;
	    }

	    private Component buildProfileTab() {
	        HorizontalLayout root = new HorizontalLayout();
	        root.setCaption("Profile");
	        root.setIcon(FontAwesome.USER);
	        root.setWidth(100.0f, Unit.PERCENTAGE);
	        root.setSpacing(true);
	        root.setMargin(true);
	        root.addStyleName("profile-form");

	        VerticalLayout pic = new VerticalLayout();
	        pic.setSizeUndefined();
	        pic.setSpacing(true);
	        Image profilePic = new Image(null, new ThemeResource(
	                "img/profile-pic-300px.jpg"));
	        profilePic.setWidth(100.0f, Unit.PIXELS);
	        pic.addComponent(profilePic);

	        root.addComponent(pic);

	        FormLayout details = new FormLayout();
	        details.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
	        root.addComponent(details);
	        root.setExpandRatio(details, 1);

	        firstNameField = new TextField("First Name");
	        firstNameField.setReadOnly(true);
	        details.addComponent(firstNameField);
	        
	        lastNameField = new TextField("Last Name");
	        lastNameField.setReadOnly(true);
	        details.addComponent(lastNameField);
	        
	        userCode = new TextField("User Code");
	        userCode.setWidth("100%");
	        userCode.setNullRepresentation("");
	        userCode.setReadOnly(true);
	        details.addComponent(userCode);
	        
	        country=new TextField("Country");
	        country.setWidth("100%");
	        try {
	        	country.setValue((CountryDao.getSingleCountry(userUI.getCountryId())).getCountryName());
			} catch (ReadOnlyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        country.setReadOnly(true);
	        details.addComponent(country);

	        Label section = new Label("Contact Info");
	        section.addStyleName(ValoTheme.LABEL_H4);
	        section.addStyleName(ValoTheme.LABEL_COLORED);
	        details.addComponent(section);

	        emailField = new TextField("Email");
	        emailField.setWidth("100%");
	        emailField.setRequired(true);
	        emailField.setNullRepresentation("");
	        details.addComponent(emailField);
	        
	        group=new TextField("User Group");
	        group.setWidth("100%");
	        try {
	        	group.setValue(userUI.getUsersGroup().getGroupName());
			} catch (ReadOnlyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        group.setReadOnly(true);
	        details.addComponent(group);
	      
	        return root;
	    }

	    private Component buildFooter() {
	        HorizontalLayout footer = new HorizontalLayout();
	        footer.addStyleName(ValoTheme.WINDOW_BOTTOM_TOOLBAR);
	        footer.setWidth(100.0f, Unit.PERCENTAGE);

	        Button ok = new Button("OK");
	        ok.addStyleName(ValoTheme.BUTTON_PRIMARY);
	        ok.addClickListener(new ClickListener() {
	            @Override
	            public void buttonClick(ClickEvent event) {
	                try {
	                    fieldGroup.commit();
	                    // Updated user should also be persisted to database. But
	                    // not in this demo.

	                    Notification success = new Notification(
	                            "Profile updated successfully");
	                    success.setDelayMsec(2000);
	                    success.setStyleName("bar success small");
	                    success.setPosition(Position.BOTTOM_CENTER);
	                    success.show(Page.getCurrent());

	                    close();
	                } catch (CommitException e) {
	                    Notification.show("Error while updating profile",
	                            Type.ERROR_MESSAGE);
	                }

	            }
	        });
	        ok.focus();
	        footer.addComponent(ok);
	        footer.setComponentAlignment(ok, Alignment.TOP_RIGHT);
	        return footer;
	    }

	    public static void open(final User user, final boolean preferencesTabActive) {
	        Window w = new UserProfileForm(user, preferencesTabActive);
	        UI.getCurrent().addWindow(w);
	        w.focus();
	    }

}
