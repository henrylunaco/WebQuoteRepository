package com.example.webquote;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import javax.servlet.annotation.WebServlet;

import com.example.themes.valo.ButtonsAndLinks;
import com.example.themes.valo.CheckBoxes;
import com.example.themes.valo.Labels;
import com.example.themes.valo.StringGenerator;
import com.example.themes.valo.TestIcon;
import com.example.themes.valo.TextFields;
import com.example.themes.valo.ValoMenuLayout;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.themes.ValoTheme;
import com.webquote.Dao.UserDao;
import com.webquote.EntityClasses.User;
import com.webquote.Forms.EnterQuoteForm;
import com.webquote.Forms.LoginView;
import com.webquote.Forms.UserProfileForm;

@SuppressWarnings("serial")
@Theme("tests-valo")
@Title("Valo Theme Test")
public class WebquoteUI extends UI {
	
	private final TestIcon testIcon = new TestIcon(100);
	ValoMenuLayout root = new ValoMenuLayout();
	ComponentContainer viewDisplay = root.getContentContainer();
	private Navigator navigator;
	private final LinkedHashMap<String, String> menuItems = new LinkedHashMap<String, String>();
    CssLayout menu = new CssLayout();
    CssLayout menuItemsLayout = new CssLayout();
    
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = WebquoteUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		 getPage().setTitle("WebQuote APP");
		 //---layoutLogin------
		 VerticalLayout layoutLogin=new VerticalLayout();
		 layoutLogin.setSizeFull();
		 Responsive.makeResponsive(layoutLogin);
		 setContent(layoutLogin);
		 //---loginForm---------
		 Component loginForm = buildLoginForm();
		 layoutLogin.addComponent(loginForm);
		 layoutLogin.setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);
	     addStyleName("loginview");
	     root.setWidth("100%");
	     
         navigator = new Navigator(this, viewDisplay);

         navigator.addView("", LoginView.class);//We can't give a name to the first view if it's the fist page. The first view to be empty (""). 
         navigator.addView("EnterQuoteForm", EnterQuoteForm.class);
         navigator.addView("buttons-and-links", ButtonsAndLinks.class);
         navigator.addView("textfields", TextFields.class);
         navigator.addView("checkboxes", CheckBoxes.class);
         
         final String f = Page.getCurrent().getUriFragment();
         if (f == null || f.equals("")) {
             navigator.navigateTo("EnterQuoteForm");
         }

         
         navigator.addViewChangeListener(new ViewChangeListener() {

             @Override
             public boolean beforeViewChange(final ViewChangeEvent event) {
                 return true;
             }

             @Override
             public void afterViewChange(final ViewChangeEvent event) {
            	 for (final Iterator<Component> it = menuItemsLayout.iterator(); it
                         .hasNext();) {
                     it.next().removeStyleName("selected");
                 }
                 for (final Entry<String, String> item : menuItems.entrySet()) {
                     if (event.getViewName().equals(item.getKey())) {
                         for (final Iterator<Component> it = menuItemsLayout
                                 .iterator(); it.hasNext();) {
                             final Component c = it.next();
                             if (c.getCaption() != null
                                     && c.getCaption().startsWith(
                                             item.getValue())) {
                                 c.addStyleName("selected");
                                 break;
                             }
                         }
                         break;
                     }
                 }
                 menu.removeStyleName("valo-menu-visible");
             }
         });
	}
	
	//*******************************************************************************************************************
	//**************************************** BUILD MAIN MENU **********************************************************
	//*******************************************************************************************************************
	
	CssLayout buildMenu() {
		// Add items Menu
		menuItems.put("EnterQuoteForm", "New WebQuote");
        menuItems.put("buttons-and-links", "My Quotes");
        menuItems.put("checkboxes", "Respond Quotes");
        menuItems.put("textfields", "Reports");
        
		final HorizontalLayout top = new HorizontalLayout();
        top.setWidth("100%");
        top.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        top.addStyleName("valo-menu-title");
        menu.addComponent(top);
        //menu.addComponent(createThemeSelect());
        final Label title = new Label(
                "<h3>Web<strong>QUOTE</strong> App</h3>", ContentMode.HTML);
        title.setSizeUndefined();
        top.addComponent(title);
        top.setExpandRatio(title, 1);
        
        final MenuBar settings = new MenuBar();
        settings.addStyleName("user-menu");
        //set the user name in to setitngs user.
        final MenuItem settingsItem = settings.addItem(getUserLogin().getFirstName()+" "+getUserLogin().getLastName(), //set the user name
                new ThemeResource("../tests-valo/img/profile-pic-300px.jpg"),
                null);
        settingsItem.addItem("Edit Profile", new Command() {
            @Override
            public void menuSelected(final MenuItem selectedItem) {
                UserProfileForm.open(getUserLogin(), false);
            }
        });
        settingsItem.addItem("Preferences", null);
        settingsItem.addSeparator();
        settingsItem.addItem("Sign Out", new Command() {
            @Override
            public void menuSelected(final MenuItem selectedItem) {
                getSession().close();
                getPage().reload();
                //getSession().getState().C;
            }
        });
        menu.addComponent(settings);
        
        menuItemsLayout.setPrimaryStyleName("valo-menuitems");
        menu.addComponent(menuItemsLayout);

        Label label = null;
        int count = -1;
        for (final Entry<String, String> item : menuItems.entrySet()) {
            if (item.getKey().equals("EnterQuoteForm")) {
                label = new Label("Main Menu", ContentMode.HTML);
                label.setPrimaryStyleName("valo-menu-subtitle");
                label.addStyleName("h4");
                label.setSizeUndefined();
                menuItemsLayout.addComponent(label);
            }
            if (item.getKey().equals("panels")) {
                label.setValue(label.getValue()
                        + " <span class=\"valo-menu-badge\">" + count
                        + "</span>");
                count = 0;
                label = new Label("Containers", ContentMode.HTML);
                label.setPrimaryStyleName("valo-menu-subtitle");
                label.addStyleName("h4");
                label.setSizeUndefined();
                menuItemsLayout.addComponent(label);
            }
            if (item.getKey().equals("forms")) {
                label.setValue(label.getValue()
                        + " <span class=\"valo-menu-badge\">" + count
                        + "</span>");
                count = 0;
                label = new Label("Other", ContentMode.HTML);
                label.setPrimaryStyleName("valo-menu-subtitle");
                label.addStyleName("h4");
                label.setSizeUndefined();
                menuItemsLayout.addComponent(label);
            }
            final Button b = new Button(item.getValue(), new ClickListener() {
                @Override
                public void buttonClick(final ClickEvent event) {
                    navigator.navigateTo(item.getKey());
                }
            });
            if (count == 2) {
                b.setCaption(b.getCaption()
                        + " <span class=\"valo-menu-badge\">123</span>");
            }
            b.setHtmlContentAllowed(true);
            b.setPrimaryStyleName("valo-menu-item");
            b.setIcon(testIcon.get());
            menuItemsLayout.addComponent(b);
            count++;
        }
        label.setValue(label.getValue() + " <span class=\"valo-menu-badge\">"
                + count + "</span>");
        
        return menu;
	}
	
	//*******************************************************************************************************************
	//**************************************** BUILD LOGIN FORM *********************************************************
	//*******************************************************************************************************************
	
	Component buildLoginForm() {
        final VerticalLayout loginPanel = new VerticalLayout();
        loginPanel.setSizeUndefined();
        loginPanel.setSpacing(true);
        Responsive.makeResponsive(loginPanel);
        loginPanel.addStyleName("login-panel");

        loginPanel.addComponent(buildLabels());
        loginPanel.addComponent(buildFields());
        loginPanel.addComponent(new CheckBox("Remember me", true));
        return loginPanel;
    }

    Component buildFields() {
        HorizontalLayout fields = new HorizontalLayout();
        fields.setSpacing(true);
        fields.addStyleName("fields");

        final TextField username = new TextField("Username");
        username.setIcon(FontAwesome.USER);
        username.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

        final PasswordField password = new PasswordField("Password");
        password.setIcon(FontAwesome.LOCK);
        password.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

        final Button signin = new Button("Sign In");
        signin.addStyleName(ValoTheme.BUTTON_PRIMARY);
        signin.setClickShortcut(KeyCode.ENTER);
        signin.focus();

        fields.addComponents(username, password, signin);
        fields.setComponentAlignment(signin, Alignment.BOTTOM_LEFT);

        signin.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(final ClickEvent event) {
            	if(username.getValue()!= null && username.getValue()!=""){
        			if(password.getValue()!= null && password.getValue()!=""){
        				try {
            				User user = UserDao.getSingleUser(username.getValue());
							getSession().setAttribute("user", user);
							System.out.println("prueba login");
							setContent(root);
						    root.setWidth("100%");
						    root.addMenu(buildMenu());
						    addStyleName(ValoTheme.UI_WITH_MENU);
        				} catch (Exception e) {
        					// TODO Auto-generated catch block
        					Notification.show("Acces Denied. You do not have permissions to access the application",Type.ERROR_MESSAGE);
        					e.printStackTrace();
        				}
        			}else{
        				Notification.show("Please enter your Password",Type.WARNING_MESSAGE);
        			}
        		}else{
        			Notification.show("Please enter your User Name",Type.WARNING_MESSAGE);
        		}
			}
            //The user name or password is incorrect, check and type again.
        });
        return fields;
    }

    Component buildLabels() {
        CssLayout labels = new CssLayout();
        labels.addStyleName("labels");

        Label welcome = new Label("Welcome");
        welcome.setSizeUndefined();
        welcome.addStyleName(ValoTheme.LABEL_H4);
        welcome.addStyleName(ValoTheme.LABEL_COLORED);
        labels.addComponent(welcome);

        Label title = new Label("<h3>Web<strong>QUOTE</strong> App</h3>", ContentMode.HTML);
        title.setSizeUndefined();
        title.addStyleName(ValoTheme.LABEL_H3);
        title.addStyleName(ValoTheme.LABEL_LIGHT);
        labels.addComponent(title);
        return labels;
    }

    public User getUserLogin(){
    	User user=(User)getSession().getAttribute("user");
    	return user;
    }

}