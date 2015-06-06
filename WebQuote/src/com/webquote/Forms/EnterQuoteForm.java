package com.webquote.Forms;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.example.themes.valo.TestIcon;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.Position;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PopupView.Content;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Select;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.Table.Align;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.Table.RowHeaderMode;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.webquote.Dao.ChangeTypeDao;
import com.webquote.Dao.CityDao;
import com.webquote.Dao.CountryDao;
import com.webquote.Dao.ProductDao;
import com.webquote.Dao.ProductsTypeDao;
import com.webquote.Dao.ProfileDao;
import com.webquote.Dao.RequestTypeDao;
import com.webquote.Dao.SIdatabaseDAO;
import com.webquote.Dao.TblWebquoteDao;
import com.webquote.Dao.TopologyTypeDao;
import com.webquote.Dao.UserDao;
import com.webquote.Dao.WebquoteTypeDao;
import com.webquote.EntityClasses.CableStationSI;
import com.webquote.EntityClasses.ChangeType;
import com.webquote.EntityClasses.City;
import com.webquote.EntityClasses.Country;
import com.webquote.EntityClasses.CrossconnectSI;
import com.webquote.EntityClasses.Product;
import com.webquote.EntityClasses.ProductsType;
import com.webquote.EntityClasses.Profile;
import com.webquote.EntityClasses.RequestType;
import com.webquote.EntityClasses.Tblwebquote;
import com.webquote.EntityClasses.TopologyType;
import com.webquote.EntityClasses.User;
import com.webquote.EntityClasses.WebquoteDetail;
import com.webquote.EntityClasses.WebquoteType;

public class EnterQuoteForm extends VerticalLayout implements View {
	
	ComboBox comboCountryA;
	ComboBox comboCountryZ;
	ComboBox comboStateZ;
	ComboBox comboCityZ;
	ComboBox ComboType;
	ComboBox ComboRequestType;
	ComboBox comboproductType;
	ComboBox comboproduct;
	ComboBox comboRequestedFor;
	ComboBox comboServiceTopology;
	ComboBox comboCHType;
	ComboBox comboPOP;
	TextField txtUnit;
	TextField txtQuantity;
	TextField txtCircuitId;
	TextField txtNameCID;
	TextField txtDealCode;
	TextField txtCustomerName;
	TextField txtEndCustomer;
	TextField txtAddressZ;
	TextField txtFloor;
	TextField txtSuite;
	TextField txtZipCode;
	TextField txtCoordinatesA;
	TextField txtLatitudeZ;
	TextField txtLongitudeZ;
	TextField txtGeneralContactName;
	TextField txtGeneralContactPhone;
	TextField txtGeneralContactMail;
	TextField txtOnSiteContactName;
	TextField txtOnSiteContactPhone;
	TextField txtOnSiteContactMail;
	TextArea txtAddressPOP;
	Label labelUser;
	HorizontalLayout row;
	Panel panelChange;
	Panel panelLocationZ;
	OptionGroup options;
	OptionGroup optionsRequestType;
	TabSheet tabsheet;
	Table tableProducts;
	final Tblwebquote webquote;
	
	
	public EnterQuoteForm(){
		//***
		webquote= new Tblwebquote();
		//****
		VerticalLayout verticalLayout=new VerticalLayout();
		addComponent(verticalLayout);
		
		MenuBar menuBar = getMenuBar();
        verticalLayout.addComponent(menuBar);
		
		//
        HorizontalLayout wrap=new HorizontalLayout();
        verticalLayout.addComponent(wrap);
        wrap.setSpacing(true);
        wrap.setWidth("100%");
        
        Label labelTitle=new Label("New WebQuote");
		labelTitle.addStyleName("h2");
		//verticalLayout.addComponent(labelTitle);
		wrap.addComponent(labelTitle);
		
		Label labelTitle2=new Label("Key Cod:");
		labelTitle2.addStyleName("failure");
		//verticalLayout.addComponent(labelTitle);
		wrap.addComponent(labelTitle2);
		wrap.setComponentAlignment(labelTitle2, Alignment.TOP_RIGHT);
		
		TestIcon testIcon = new TestIcon(60);
		
		Panel panel = new Panel("General Information");
        panel.setIcon(testIcon.get());
        panel.addStyleName("color1");
        panel.setContent(BuildpanelGeneral());
        verticalLayout.addComponent(panel);
        
        panelChange = new Panel("Change Information");
        panelChange.setIcon(testIcon.get());
        panelChange.addStyleName("color1");
        panelChange.setContent(panelChangeType());
        panelChange.setVisible(false);
        verticalLayout.addComponent(panelChange);
        
        HorizontalLayout h2=new HorizontalLayout();
        h2.setSizeFull();
        //verticalLayout.addComponent(h2);
        
        Panel panelLocationA = new Panel("Node A");
        panelLocationA.setIcon(testIcon.get());
        panelLocationA.addStyleName("well");
        panelLocationA.setContent(buildPanelLocationA());
        verticalLayout.addComponent(panelLocationA);
        
        panelLocationZ = new Panel("Customer Location Z");
        panelLocationZ.setIcon(testIcon.get());
        panelLocationZ.addStyleName("color1");
        panelLocationZ.setContent(buildPanelLocationZ());
        verticalLayout.addComponent(panelLocationZ);
        
        HorizontalLayout h1=new HorizontalLayout();
        h1.setSizeFull();
        verticalLayout.addComponent(h1);
        
        Panel panelContact = new Panel("Node Contact");
        panelContact.setIcon(testIcon.get());
        panelContact.addStyleName("color1");
        panelContact.setContent(panelGeneralContact());
        h1.addComponent(panelContact);
        
        Panel panelContact2 = new Panel("Customer On-site Contact");
        panelContact2.setIcon(testIcon.get());
        panelContact2.addStyleName("color1");
        panelContact2.setContent(panelOnSiteContact());
        h1.addComponent(panelContact2);
        
        Panel panelNotes=new Panel("Comments");
        panelNotes.addStyleName("notes");
        panelNotes.setContent(buildNotes());
        verticalLayout.addComponent(panelNotes);
        
        TabSheet ts = new TabSheet();
        ts.addStyleName("framed compact-tabbar");
        ts.addTab(buildFormProduct(), "Products");
        ts.addTab(null, "Attachments");
        FillTableProducts();
        verticalLayout.addComponent(ts);
        
        setRequiredFields(1);
	}
	
	Component BuildpanelGeneral(){
		FormLayout layout = new FormLayout();
		layout.addStyleName("light");
        layout.setMargin(true);
        layout.setSpacing(true);
        
        optionsRequestType = new OptionGroup("Request Type");
        optionsRequestType.addStyleName("horizontal");
        optionsRequestType.addItem("Single Point");
        optionsRequestType.addItem("Multi-Point");
        optionsRequestType.select("Single Point");
        layout.addComponent(optionsRequestType);
        
        
        //ComboRequestType
        try {
        	ComboRequestType=new ComboBox("Request Type",RequestTypeDao.getAllRequestTypes());
        	ComboRequestType.setRequired(true);
        	ComboRequestType.setItemCaptionMode(ItemCaptionMode.PROPERTY);
        	ComboRequestType.setItemCaptionPropertyId("requestTypeName");
        	ComboRequestType.addStyleName("small");
        	ComboRequestType.setWidth("10em");
			//layout.addComponent(ComboRequestType);
			ComboRequestType.addValueChangeListener(new ValueChangeListener(){
				@Override
				public void valueChange(ValueChangeEvent event) {
					// TODO Auto-generated method stub
					if(ComboRequestType.getValue()!=null){
						if(((RequestType)ComboRequestType.getValue()).getRequestTypeId()==1){
							panelLocationZ.setVisible(true);
						}else{
							panelLocationZ.setVisible(false);
						}
					}
				}
				
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //ComboType
        try {
        	ComboType=new ComboBox("Webquote Type",WebquoteTypeDao.geWebquoteTypes());
        	ComboType.setRequired(true);
        	ComboType.setItemCaptionMode(ItemCaptionMode.PROPERTY);
        	ComboType.setItemCaptionPropertyId("webquoteTypeName");
        	ComboType.addStyleName("small");
        	ComboType.setWidth("10em");
			layout.addComponent(ComboType);
			ComboType.addValueChangeListener(new ValueChangeListener(){
				@Override
				public void valueChange(ValueChangeEvent event) {
					// TODO Auto-generated method stub
					if(ComboType.getValue()!=null){
						if(((WebquoteType)ComboType.getValue()).getWequoteTypeId()==2){
							panelChange.setVisible(true);
						}else{
							panelChange.setVisible(false);
						}
						setRequiredFields(((WebquoteType)ComboType.getValue()).getWequoteTypeId());
					}
				}
				
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //txtDealCode
        txtDealCode=new TextField("Deal Code");
        txtDealCode.setStyleName("small");
        txtDealCode.setRequired(true);
        layout.addComponent(txtDealCode);
        //txtCustomerName
        txtCustomerName=new TextField("Customer Name");
        txtCustomerName.setStyleName("small");
        txtCustomerName.setRequired(true);
        layout.addComponent(txtCustomerName);
        //txtEndCustomer
        txtEndCustomer=new TextField("End Customer");
        txtEndCustomer.setStyleName("small");
        txtEndCustomer.setRequired(true);
        layout.addComponent(txtEndCustomer);

        //horizontalLayoutUser
        HorizontalLayout horizontalLayoutUser= new HorizontalLayout();
        horizontalLayoutUser.setCaption("Requested For");
        horizontalLayoutUser.setSpacing(true);
        horizontalLayoutUser.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        //layout.addComponent(horizontalLayoutUser);
        //comboRequestedFor
        try {
        	Profile sales = ProfileDao.getSingleProfileId(3); // Id de la tabla de Perfiles "Sales"
        	comboRequestedFor=new ComboBox("Requested For");
        	comboRequestedFor.setContainerDataSource(UserDao.getAllUserProfile(sales));
        	comboRequestedFor.addStyleName("small");
        	comboRequestedFor.setWidth("10em");
        	comboRequestedFor.setRequired(true);
        	comboRequestedFor.setItemCaptionMode(ItemCaptionMode.PROPERTY);
        	comboRequestedFor.setItemCaptionPropertyId("userCode");
        	layout.addComponent(comboRequestedFor);
        	comboRequestedFor.addValueChangeListener(new ValueChangeListener(){
				@Override
				public void valueChange(ValueChangeEvent event) {
					// TODO Auto-generated method stub
					if(comboRequestedFor.getValue()!=null){
						User user=(User) comboRequestedFor.getValue();
						labelUser.setVisible(true);
						labelUser.setValue(user.getFirstName() + " "+ user.getLastName()+ " - Profile: "+ user.getProfile().getProfileName());
					}else{
						labelUser.setVisible(false);
					}
				}
				
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			labelUser.setVisible(false);
			e.printStackTrace();
		}
        
        //labelUser
        labelUser=new Label();
        // labelUser.addStyleName("h3");
        labelUser.addStyleName("small");
        labelUser.setVisible(false);
        layout.addComponent(labelUser);
        
        //comboServiceTopology
        try {
        	comboServiceTopology=new ComboBox("Service Topology",TopologyTypeDao.getTopologyTypes());
        	comboServiceTopology.addStyleName("small");
        	comboServiceTopology.setWidth("10em");
        	comboServiceTopology.setRequired(true);
        	comboServiceTopology.setItemCaptionMode(ItemCaptionMode.PROPERTY);
        	comboServiceTopology.setItemCaptionPropertyId("name");
        	layout.addComponent(comboServiceTopology);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return layout;
	}
	
	Component panelChangeType(){
		FormLayout layout= new FormLayout();
		layout.addStyleName("light");
		layout.setMargin(true);
        layout.setSpacing(true);
        //comboCHType
        try {
        	comboCHType=new ComboBox("Change Type",ChangeTypeDao.getChangeTypes());
        	comboCHType.addStyleName("small");
        	comboCHType.setWidth("10em");
        	comboCHType.setItemCaptionMode(ItemCaptionMode.PROPERTY);
        	comboCHType.setItemCaptionPropertyId("name");
        	layout.addComponent(comboCHType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //txtCircuitId
        txtCircuitId=new TextField("Circuit ID");
        txtCircuitId.setWidth("5em");
        txtCircuitId.setImmediate(true);
        layout.addComponent(txtCircuitId);
        txtCircuitId.addValueChangeListener(new Property.ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				// TODO Auto-generated method stub
				String value = (String) event.getProperty().getValue();
				CrossconnectSI crossconnect=SIdatabaseDAO.getCrossconnect(value);
				if(crossconnect.getCID()!=null){
					txtNameCID.setVisible(true);
					txtNameCID.setReadOnly(false);
					txtNameCID.setValue(crossconnect.getCustomerName()+"   -   Main Order Status: "+crossconnect.getMain_order_status());
					txtNameCID.setReadOnly(true);
					row.addComponent(buildPopupViewCID());
				}else{
					txtNameCID.setVisible(false);
					Notification.show("The Circuit ID not exist in SI database.", Type.ERROR_MESSAGE);
				}
			}
		});
        //txtNameCID
        txtNameCID=new TextField("Customer Name");
        txtNameCID.setImmediate(true);
        txtNameCID.setReadOnly(true);
        txtNameCID.setVisible(false);
        layout.addComponent(txtNameCID);
        //wrap: row
        row = new HorizontalLayout();
        row.addStyleName("wrapping");
        row.setSpacing(true);
        layout.addComponent(row);
        return layout;
   }
	
	Component panelGeneralContact(){
		FormLayout layout= new FormLayout();
		layout.addStyleName("light");
		layout.setMargin(true);
        layout.setSpacing(true);
        //txtContactName
        txtGeneralContactName=new TextField("Contact Name");
        txtGeneralContactName.setStyleName("small");
        layout.addComponent(txtGeneralContactName);
        //txtGeneralContactPhone
        txtGeneralContactPhone=new TextField("Contact Phone");
        txtGeneralContactPhone.setStyleName("small");
        layout.addComponent(txtGeneralContactPhone);
        //txtContactMail
        txtGeneralContactMail=new TextField("Contact Mail");
        txtGeneralContactMail.setStyleName("small");
        layout.addComponent(txtGeneralContactMail);
        return layout;
   }
	
	Component panelOnSiteContact(){
		FormLayout layout= new FormLayout();
		layout.addStyleName("light");
		layout.setMargin(true);
        layout.setSpacing(true);
        //txtContactName
        txtOnSiteContactName=new TextField("On-site Contact Name");
        txtOnSiteContactName.setStyleName("small");
        layout.addComponent(txtOnSiteContactName);
        //txtContactPhone
        txtOnSiteContactPhone=new TextField("On-site Contact Phone");
        txtOnSiteContactPhone.setStyleName("small");
        layout.addComponent(txtOnSiteContactPhone);
        //txtContactMail
        txtOnSiteContactMail=new TextField("On-site Contact Mail");
        txtOnSiteContactMail.setStyleName("small");
        layout.addComponent(txtOnSiteContactMail);
        return layout;
   }
	
	Component buildPanelLocationA(){
		FormLayout layout= new FormLayout();
		layout.addStyleName("light");
		layout.setMargin(true);
        layout.setSpacing(true);
        //comboCountry
        try {
        	comboCountryA=new ComboBox("Country",CountryDao.getAllCountries());
        	comboCountryA.addStyleName("small");
        	comboCountryA.setWidth("20em");
        	comboCountryA.setImmediate(true);
        	comboCountryA.addValueChangeListener(new ValueChangeListener(){
				@Override
				public void valueChange(ValueChangeEvent event) {
					// TODO Auto-generated method stub
					try{
						if(comboCountryA.getValue()!=null){
							comboPOP.removeAllItems();
							txtAddressPOP.setReadOnly(false);
							txtAddressPOP.setValue("");
							txtAddressPOP.setReadOnly(true);
							txtCoordinatesA.setReadOnly(false);
						    txtCoordinatesA.setValue("");
						    txtCoordinatesA.setReadOnly(true);
							//--------------
						    //Se crea un contenedor el cual se almacene los POPs de CN traidos de la base de datos de SI.
						    //Este contenedor es asignado como datasource al combobox.
				        	IndexedContainer iContainer = new IndexedContainer();
				        	iContainer.addContainerProperty("name", String.class, "");
				        	iContainer.addContainerProperty("country", String.class, "");
				        	iContainer.addContainerProperty("address", String.class, "");
				        	iContainer.addContainerProperty("latitude", String.class, "");
				        	iContainer.addContainerProperty("longitude", String.class, "");
				        	String country=((Country)comboCountryA.getValue()).getCountryCode();
				    		ArrayList<CableStationSI>lista=SIdatabaseDAO.getListPOPColumbus(country);
							for(CableStationSI data : lista){
								Item newItem = iContainer.getItem(iContainer.addItem());
								newItem.getItemProperty("name").setValue(data.getDescription());
								newItem.getItemProperty("country").setValue(data.getCountry());
								newItem.getItemProperty("address").setValue(data.getAddress());
								newItem.getItemProperty("latitude").setValue(data.getLatitude());
								newItem.getItemProperty("longitude").setValue(data.getLongitude());
							}
							comboPOP.setContainerDataSource(iContainer);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
        		
        	});
        	//comboCountry.setWidth("10em");
        	comboCountryA.setItemCaptionMode(ItemCaptionMode.PROPERTY);
        	comboCountryA.setItemCaptionPropertyId("countryName");
        	layout.addComponent(comboCountryA);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //--comboPOP-----------------------------
        comboPOP=new ComboBox("POP");
        comboPOP.setWidth("20em");
        comboPOP.setItemCaptionMode(ItemCaptionMode.PROPERTY);
        comboPOP.setItemCaptionPropertyId("name");
        comboPOP.addStyleName("small");
        comboPOP.setImmediate(true);
        layout.addComponent(comboPOP);
        comboPOP.addValueChangeListener(new ValueChangeListener(){
			@Override
			public void valueChange(ValueChangeEvent event) {
				// TODO Auto-generated method stub
				try{
					if(comboPOP.getValue()!=null){
						//this code segment  allow that you can access the container value of ComboBox
						//Este segmento de codigo permite que puedas acceder al valor del comboBox seleccionado.
						comboPOP.getItemIds();
					    Property changedProperty = event.getProperty();
					    Object selectedStatus = (Object) comboPOP.getValue(); //it is get Value but gives object ID as an Object
					    Item rowItem = comboPOP.getItem(selectedStatus);
					    String address = (String) rowItem.getItemProperty("address").getValue(); 
					    String gpsLat=(String) rowItem.getItemProperty("latitude").getValue();
					    String gpsLon=(String) rowItem.getItemProperty("longitude").getValue();
					    //------------
					    txtAddressPOP.setReadOnly(false);
					    txtAddressPOP.setValue(address);
					    txtAddressPOP.setReadOnly(true);
					    //------------
					    txtCoordinatesA.setReadOnly(false);
					    txtCoordinatesA.setValue(gpsLat+" - "+gpsLon);
					    txtCoordinatesA.setReadOnly(true);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
    		
    	});
					
        //--txtAddressPOP
        txtAddressPOP= new TextArea("Address Node");
        txtAddressPOP.setStyleName("color1");
        txtAddressPOP.setReadOnly(true);
        layout.addComponent(txtAddressPOP);
        //
        txtCoordinatesA=new TextField("GPS Coordinates");
        txtCoordinatesA.setStyleName("small");
        txtCoordinatesA.setReadOnly(true);
        layout.addComponent(txtCoordinatesA);
                       
		return layout;
   }
	
	Component buildPanelLocationZ(){
		FormLayout layout= new FormLayout();
		layout.addStyleName("light");
		layout.setMargin(true);
        layout.setSpacing(true);
        //comboCountry
        try {
        	comboCountryZ=new ComboBox("Country",CountryDao.getAllCountries());
        	comboCountryZ.addStyleName("small");
        	comboCountryZ.setWidth("18em");
        	comboCountryZ.setRequired(true);
        	comboCountryZ.setImmediate(true);
        	comboCountryZ.addValueChangeListener(new ValueChangeListener(){
				@Override
				public void valueChange(ValueChangeEvent event) {
					// TODO Auto-generated method stub
					try{
						comboCityZ.removeAllItems();
						if(comboCountryZ.getValue()!=null){
							comboCityZ.setContainerDataSource(CityDao.getAllCities((Country)comboCountryZ.getValue()));
							comboCityZ.setItemCaptionMode(ItemCaptionMode.PROPERTY);
				        	comboCityZ.setItemCaptionPropertyId("cityName");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
        		
        	});
        	//comboCountry.setWidth("10em");
        	comboCountryZ.setItemCaptionMode(ItemCaptionMode.PROPERTY);
        	comboCountryZ.setItemCaptionPropertyId("countryName");
        	layout.addComponent(comboCountryZ);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //comboCity
        try {
        	comboCityZ=new ComboBox("City");
        	comboCityZ.setWidth("18em");
        	comboCityZ.addStyleName("small");
        	comboCityZ.setRequired(true);
        	//comboCity.setWidth("10em");
        	layout.addComponent(comboCityZ);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //txtAddress
        txtAddressZ=new TextField("Address");
        txtAddressZ.setStyleName("small");
        txtAddressZ.setRequired(true);
        layout.addComponent(txtAddressZ);
        //txtFloor
        txtFloor=new TextField("Floor Number");
        txtFloor.setStyleName("small");
        layout.addComponent(txtFloor);
        //txtSuite
        txtSuite=new TextField("Suite Number");
        txtSuite.setStyleName("small");
        layout.addComponent(txtSuite);
        //txtZipCode
        txtZipCode=new TextField("Zip Code");
        txtZipCode.setStyleName("small");
        layout.addComponent(txtZipCode);
        //txtLatitudeZ
        txtLatitudeZ=new TextField("Latitude Coordinate");
        txtLatitudeZ.setStyleName("small");
        layout.addComponent(txtLatitudeZ);
        //txtLongitudeZ
        txtLongitudeZ = new TextField("longitude Coordinate");
        txtLongitudeZ.setStyleName("small");
        layout.addComponent(txtLongitudeZ);
        
        return layout;
   }
	
	Component buildFormProduct(){
		//VerticalContent
		VerticalLayout verticalContent=new VerticalLayout();
		verticalContent.setMargin(true);
		verticalContent.setSpacing(true);
		//content
		HorizontalLayout content=new HorizontalLayout();
		content.setMargin(false);
		content.setSpacing(true);
		verticalContent.addComponent(content);
		//comboproductType
		comboproductType = new ComboBox("Product");
		comboproductType.addStyleName("color3");
		comboproductType.setRequired(true);
	    try {
		   comboproductType.setContainerDataSource(ProductsTypeDao.getProductsType());
		   comboproductType.setItemCaptionMode(ItemCaptionMode.PROPERTY);
		   comboproductType.setItemCaptionPropertyId("productTypeName");
		   comboproductType.addValueChangeListener(new ValueChangeListener(){
				@Override
				public void valueChange(ValueChangeEvent event) {
					// TODO Auto-generated method stub
					if(comboproductType.getValue()!=null){
						try {
							comboproduct.setContainerDataSource(ProductDao.getAllProductusByType((ProductsType)comboproductType.getValue()));
							comboproduct.setItemCaptionMode(ItemCaptionMode.PROPERTY);
		                	comboproduct.setItemCaptionPropertyId("productName");
		                	txtUnit.setVisible(false);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                }
				}
				
			});
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	    content.addComponent(comboproductType);
	    
	    //comboproduct
  		comboproduct = new ComboBox("Interface");
  		comboproduct.addStyleName("color3");
  		comboproduct.setImmediate(true);
  		comboproduct.setRequired(true);
  	    comboproduct.addValueChangeListener(new ValueChangeListener(){
			@Override
			public void valueChange(ValueChangeEvent event) {
				// TODO Auto-generated method stub
				if(comboproduct.getValue()!=null){
					try{
						if(((Product)comboproduct.getValue()).getDescription()!=null){
							txtUnit.setVisible(true);
							txtUnit.setReadOnly(false);
							txtUnit.setValue(((Product)comboproduct.getValue()).getDescription());
							txtUnit.setReadOnly(true);
						}
 		            } catch (Exception e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
 					}
                }
			}
				
		});  		
  	    content.addComponent(comboproduct);
  	    
  	    //txtQuantity
  	    txtQuantity = new TextField("Quantity");
  	    txtQuantity.addStyleName("color3");
  	    txtQuantity.setWidth("70px");
  	    txtQuantity.setRequired(true);
  	    content.addComponent(txtQuantity);
  	    
  	    //txtUnit
  	    txtUnit = new TextField("Description");
  	    txtUnit.addStyleName("borderless");
  	    txtUnit.setReadOnly(true);
  	    txtUnit.setVisible(false);
  	    content.addComponent(txtUnit);
  	    
  	    //options Terms
        options = new OptionGroup("Contract Terms");
        options.setMultiSelect(true);
        options.setWidth("500px");
        options.addStyleName("horizontal");
        options.addItem("12 months");
        options.addItem("24 months");
        options.addItem("36 months");
        verticalContent.addComponent(options);
  	    
  	    //btnAddProduct
  	    Button btnAddProduct=new Button("Add");
  	    btnAddProduct.addStyleName("primary");
  	    btnAddProduct.setDescription("Add product");
  	    btnAddProduct.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(final ClickEvent event) {
                if(comboproduct.getValue()!=null){
                	if(txtQuantity.getValue()!=null){
                		if(isNumeric(txtQuantity.getValue().toString())==true){
                			if(options.isSelected("12 months")==true || options.isSelected("24 months")==true || options.isSelected("36 months")==true){
			                		Product product=(Product)comboproduct.getValue();
			                		int q= Integer.parseInt(txtQuantity.getValue().toString());
			                		if(options.isSelected("12 months")==true){
			                			AddProductToQuote(product,q,12);
			                		}
			                		if(options.isSelected("24 months")==true){
			                			AddProductToQuote(product,q,24);
			                		}
			                		if(options.isSelected("36 months")==true){
			                			AddProductToQuote(product,q,36);
			                		}
			                		FillTableProducts();
                			}else{
                				Notification.show("Select Contract Term in general information", Type.WARNING_MESSAGE);
                			}
                		}else{
                			Notification.show("The field Quantity must be a numeric value", Type.WARNING_MESSAGE);
                		}
                	}else{
                		Notification.show("Please enter a quantity", Type.WARNING_MESSAGE);
                	}
                }else{
                	Notification.show("Please select a product", Type.WARNING_MESSAGE);
                }
            }
        });
  	    verticalContent.addComponent(btnAddProduct);
  	    
  	    //tableProducts
  	    tableProducts=new Table();
  	    tableProducts.addStyleName("compact");
  	    tableProducts.setWidth("100%");
  	    tableProducts.addContainerProperty("DLT", Button.class, null);
  	    tableProducts.addGeneratedColumn("DLT", new ColumnGenerator() {
  	    	@Override
  	    	public Object generateCell(Table source, final Object itemId,
  	    		Object columnId) {
  	    		Button b = new Button();
  	    		b.setIcon(new ThemeResource("../tests-valo/img/cancel.png"));
  	    		b.addStyleName("icon-only");
  	    		b.setWidth("45px");
  	    		b.setHeight("30px");
  	    		b.setDescription("Delete product");
  	    		b.addClickListener(new ClickListener() {
  	              @Override
  	            public void buttonClick(final ClickEvent event) {
  	                deleteProductFromQuotes(itemId);
  	                FillTableProducts();
  	            }
  	        });
  	    		return b;
  	    	}
  	    });
  	    tableProducts.setRowHeaderMode(RowHeaderMode.HIDDEN);
  	    tableProducts.setRowHeaderMode(RowHeaderMode.INDEX);
  	    tableProducts.addContainerProperty("Product",String.class, null);
  	    tableProducts.addContainerProperty("Interface",String.class, null);
  	    tableProducts.addContainerProperty("Unit",String.class, null);
  	    tableProducts.addContainerProperty("Quantity",String.class, null);
  	    tableProducts.addContainerProperty("Term",String.class, null);
  	    tableProducts.setColumnWidth("DLT",50);
  	    tableProducts.setColumnAlignment("DLT",Align.CENTER);
	    
  	    verticalContent.addComponent(tableProducts);
		return verticalContent;
	}
	
	Component buildPopupViewCID(){
			PopupView pv = new PopupView(new Content() {
            CrossconnectSI cr=SIdatabaseDAO.getCrossconnect(txtCircuitId.getValue());
            @Override
            public Component getPopupComponent() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                return new VerticalLayout() {
                    {
                        setMargin(true);
                        addComponent(new Label("<b>Ciruit ID:</b> "+cr.getCID(), ContentMode.HTML));
                        addComponent(new Label("<b>CKT:</b> "+cr.getCKT(), ContentMode.HTML));
                        addComponent(new Label("<b>Status:</b> "+cr.getMain_order_status(), ContentMode.HTML));
                        addComponent(new Label("<b>Country A:</b> "+cr.getCountryA(), ContentMode.HTML));
                        addComponent(new Label("<b>Landing A:</b> "+cr.getLandingA(), ContentMode.HTML));
                        addComponent(new Label("<b>Country Z:</b> "+cr.getCountryZ(), ContentMode.HTML));
                        addComponent(new Label("<b>Landing Z:</b> "+cr.getLandingZ(), ContentMode.HTML));
                        addComponent(new Label("<b>BW:</b> "+cr.getBW(), ContentMode.HTML));
                    }
                };
            }

			@Override
			public String getMinimizedValueAsHTML() {
				// TODO Auto-generated method stub
				return "Show more information...";
			}
			 });
			pv.setHideOnMouseOut(false);
			return pv;
	}
	
	private Component buildNotes() {
        TextArea notes = new TextArea("Notes");
        notes.setSizeFull();
        notes.addStyleName(ValoTheme.TEXTAREA_BORDERLESS);
        return notes;
    }
	
	public void AddProductToQuote(Product product,int quantity,int term){
		WebquoteDetail detail;
		detail=new WebquoteDetail();
		detail.setProduct(product);
		detail.setQuantity(quantity);
		detail.setContractTerm(term);
		if(webquote.getWebquoteDetails()==null){
			Set<WebquoteDetail> list=new HashSet<WebquoteDetail>();
			webquote.setWebquoteDetails(list);
		}
		webquote.getWebquoteDetails().add(detail);
		
	}
	
	public void deleteProductFromQuotes(Object id){
		int i = (Integer) id;
		WebquoteDetail x=null;
		for(WebquoteDetail data : webquote.getWebquoteDetails()){
			if(i==data.hashCode()){
				x=data;
			}
		}
		if(x!=null){
			webquote.getWebquoteDetails().remove(x);
		}
	}
	
	public void FillTableProducts(){
		if(webquote.getWebquoteDetails()!=null){
			tableProducts.removeAllItems();
			for(WebquoteDetail data : webquote.getWebquoteDetails()){
				tableProducts.addItem(new Object[]{""+data.getProduct().getProductsType().getProductTypeName(),""+data.getProduct().getProductName(),
						""+data.getProduct().getUnit().getUnitName(),""+data.getQuantity(),""+data.getContractTerm()},data.hashCode());
			}
        }
	}
	
	private static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	public void setRequiredFields(int id){
		//set required FALSE
		comboCountryZ.setRequired(false);
		//comboStateZ.setRequired(false);
		comboCityZ.setRequired(false);
		ComboType.setRequired(false);
		comboServiceTopology.setRequired(false);
		comboCHType.setRequired(false);
		txtCircuitId.setRequired(false);
		txtDealCode.setRequired(false);
		txtCustomerName.setRequired(false);
		txtEndCustomer.setRequired(false);
		comboRequestedFor.setRequired(false);
		txtAddressZ.setRequired(false);
		txtFloor.setRequired(false);
		txtSuite.setRequired(false);
		txtZipCode.setRequired(false);
		txtLatitudeZ.setRequired(false);
		txtGeneralContactName.setRequired(false);
		txtGeneralContactPhone.setRequired(false);
		txtGeneralContactMail.setRequired(false);
		txtOnSiteContactName.setRequired(false);
		txtOnSiteContactPhone.setRequired(false);
		txtOnSiteContactMail.setRequired(false);
		
		//set required TRUE
		ComboType.setRequired(true);
		this.txtDealCode.setRequired(true);
		this.txtCustomerName.setRequired(true);
		this.comboRequestedFor.setRequired(true);
		this.comboServiceTopology.setRequired(true);
		options.setRequired(true);
		this.comboCountryZ.setRequired(true);
		this.comboCityZ.setRequired(true);
		this.txtAddressZ.setRequired(true);
		this.txtGeneralContactMail.setRequired(true);
		this.txtGeneralContactName.setRequired(true);
		this.txtGeneralContactPhone.setRequired(true);
		this.comboPOP.setRequired(true);
		if(id==2){
			//CHANGE
			this.comboCHType.setRequired(true);
			this.txtCircuitId.setRequired(true);
		}
		if(id==3){
			//FIRM ORDER
			this.txtFloor.setRequired(true);
			this.txtSuite.setRequired(true);
			this.txtOnSiteContactMail.setRequired(true);
			this.txtOnSiteContactName.setRequired(true);
			this.txtOnSiteContactPhone.setRequired(true);
		}
	}
	
	public void validateFieldsForm(int opcion){
		//option=1 ->DRAFT; option=2 SEND;
		String field=null;
		try{
			// Set User
			webquote.setCreateUser((User)getSession().getAttribute("user"));
			webquote.setRequestType(1); // Default set single-point = 1
			
			// Panel General Information
			if (ComboType.isRequired()){
				if(ComboType.isEmpty()==false){
					webquote.setWebquoteType((WebquoteType)ComboType.getValue());
				}else{
					field=ComboType.getCaption();
					Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
					throw new Exception();
				}
			}
			if (this.txtDealCode.isRequired()){
				if(txtDealCode.isEmpty()==false){
					webquote.setDealCode(txtDealCode.getValue());
				}else{
					field=txtDealCode.getCaption();
					Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
					throw new Exception();
				}
			}
			if (this.txtCustomerName.isRequired()){
				if(txtCustomerName.isEmpty()==false){
					webquote.setCustomerName(txtCustomerName.getValue());
				}else{
					field=txtCustomerName.getCaption();
					Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
					throw new Exception();
				}
			}
			if (this.txtEndCustomer.isRequired()){
				if(txtEndCustomer.isEmpty()==false){
					webquote.setCustomerName(txtEndCustomer.getValue());
				}else{
					field=txtEndCustomer.getCaption();
					Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
					throw new Exception();
				}
			}
			if (this.comboRequestedFor.isRequired()){
				if(comboRequestedFor.isEmpty()==false){
					webquote.setUser1((User)comboRequestedFor.getValue());
				}else{
					field=comboRequestedFor.getCaption();
					Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
					throw new Exception();
				}
			}
			if (this.comboServiceTopology.isRequired()){
				if(comboServiceTopology.isEmpty()==false){
					webquote.setTopologyType((TopologyType)comboServiceTopology.getValue());
				}else{
					field=comboServiceTopology.getCaption();
					Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
					throw new Exception();
				}
			}
			//OPCION = SEND
			if(opcion==2){
				//Panel Change Information
				if (this.comboCHType.isRequired()){
					if(comboCHType.isEmpty()==false){
						webquote.setChangeType((ChangeType)comboCHType.getValue());
					}else{
						field=comboCHType.getCaption();
						Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
						throw new Exception();
					}
				}
				if (this.txtCircuitId.isRequired()){
					if(txtCircuitId.isEmpty()==false){
						webquote.setCircuitId(txtCircuitId.getValue());
					}else{
						field=txtCircuitId.getCaption();
						Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
						throw new Exception();
					}
				}
				//Panel Node A
				if (this.comboCountryA.isRequired()){
					if(comboCountryA.isEmpty()==false){
						webquote.setCountry((Country)comboCountryA.getValue());
					}else{
						field=comboCountryA.getCaption();
						Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
						throw new Exception();
					}
				}
				if (this.comboPOP.isRequired()){
					if(comboPOP.isEmpty()==false){
						//this code segment  allow that you can access the container value of ComboBox
						comboPOP.getItemIds();
						Object selectedStatus = (Object) comboPOP.getValue(); //it is get Value but gives object ID as an Object
					    Item rowItem = comboPOP.getItem(selectedStatus);
					    String description=(String) rowItem.getItemProperty("name").getValue();
					    String address = (String) rowItem.getItemProperty("address").getValue(); 
					    String gpsLat=(String) rowItem.getItemProperty("latitude").getValue();
					    String gpsLon=(String) rowItem.getItemProperty("longitude").getValue();
					    //---
					    webquote.setLocationDescription(description);
					    webquote.setLocationAddress(address);
					    webquote.setLocationLatitude(gpsLat);
					    webquote.setLocationLongitude(gpsLon);
					}else{
						field=comboPOP.getCaption();
						Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
						throw new Exception();
					}
				}
				// Panel Customer Location Z
				if (this.comboCountryZ.isRequired()){
					if(comboCountryZ.isEmpty()==false){
						webquote.setLocationZCountryId((Country)comboCountryZ.getValue());
					}else{
						field=comboCountryZ.getCaption();
						Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
						throw new Exception();
					}
				}
				if (this.comboCityZ.isRequired()){
					if(comboCityZ.isEmpty()==false){
						webquote.setLocationZCityId((City)comboCityZ.getValue());
					}else{
						field=comboCityZ.getCaption();
						Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
						throw new Exception();
					}
				}
				if (this.txtAddressZ.isRequired()){
					if(txtAddressZ.isEmpty()==false){
						webquote.setLocationZAddress(txtAddressZ.getValue());
					}else{
						field=txtAddressZ.getCaption();
						Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
						throw new Exception();
					}
				}
				if (this.txtFloor.isRequired()){
					if(txtFloor.isEmpty()==false){
						webquote.setLocationZFloor(txtFloor.getValue());
					}else{
						field=txtFloor.getCaption();
						Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
						throw new Exception();
					}
				}
				if (this.txtSuite.isRequired()){
					if(txtSuite.isEmpty()==false){
						webquote.setLocationZFloor(txtSuite.getValue());
					}else{
						field=txtSuite.getCaption();
						Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
						throw new Exception();
					}
				}
				if (this.txtZipCode.isRequired()){
					if(txtZipCode.isEmpty()==false){
						webquote.setLocationZZipCode(txtZipCode.getValue());
					}else{
						field=txtZipCode.getCaption();
						Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
						throw new Exception();
					}
				}
				if (this.txtLatitudeZ.isRequired()){
					if(txtLatitudeZ.isEmpty()==false){
						webquote.setLocationZLatitude(txtLatitudeZ.getValue());
					}else{
						field=txtLatitudeZ.getCaption();
						Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
						throw new Exception();
					}
				}
				if (this.txtLongitudeZ.isRequired()){
					if(txtLongitudeZ.isEmpty()==false){
						webquote.setLocationzLongitude(txtLongitudeZ.getValue());
					}else{
						field=txtLongitudeZ.getCaption();
						Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
						throw new Exception();
					}
				}
				// Panel General Contact
				if (this.txtGeneralContactName.isRequired()){
					if(txtGeneralContactName.isEmpty()==false){
						webquote.setGeneralContactName(txtGeneralContactName.getValue());
					}else{
						field=txtGeneralContactName.getCaption();
						Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
						throw new Exception();
					}
				}
				if (this.txtGeneralContactPhone.isRequired()){
					if(txtGeneralContactPhone.isEmpty()==false){
						webquote.setGeneralContactPhone(txtGeneralContactPhone.getValue());
					}else{
						field=txtGeneralContactPhone.getCaption();
						Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
						throw new Exception();
					}
				}
				if (this.txtGeneralContactMail.isRequired()){
					if(txtGeneralContactMail.isEmpty()==false){
						webquote.setGeneralContactEmail(txtGeneralContactMail.getValue());
					}else{
						field=txtGeneralContactMail.getCaption();
						Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
						throw new Exception();
					}
				}
				// Panel Customer On-site contact
				if (this.txtOnSiteContactName.isRequired()){
					if(txtOnSiteContactName.isEmpty()==false){
						webquote.setOnsiteContactName(txtOnSiteContactName.getValue());
					}else{
						field=txtOnSiteContactName.getCaption();
						Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
						throw new Exception();
					}
				}
				if (this.txtOnSiteContactPhone.isRequired()){
					if(txtOnSiteContactPhone.isEmpty()==false){
						webquote.setOnsiteContactPhone(txtOnSiteContactPhone.getValue());
					}else{
						field=txtOnSiteContactPhone.getCaption();
						Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
						throw new Exception();
					}
				}
				if (this.txtOnSiteContactMail.isRequired()){
					if(txtOnSiteContactMail.isEmpty()==false){
						webquote.setOnsiteContactEmail(txtOnSiteContactMail.getValue());
					}else{
						field=txtOnSiteContactMail.getCaption();
						Notification.show("The "+ field +" field is requiered.",Type.ERROR_MESSAGE);
						throw new Exception();
					}
				}
			}
			//SAVE REGISTER
			SaveWebquote(webquote);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR VALIDACION");
			//e.printStackTrace();
		}
	}
	
	public MenuBar getMenuBar() {
        Command click = new Command() {
            @Override
            public void menuSelected(MenuItem selectedItem) {
                if(selectedItem.getText().equals("Draft")){
                	validateFieldsForm(1);
                }
                if(selectedItem.getText().equals("Save")){
                	validateFieldsForm(2);
                }
            }
        };

        MenuBar menubar = new MenuBar();
        menubar.setWidth("100%");
        menubar.addItem("Draft", click).setIcon(FontAwesome.EDIT);
        menubar.addItem("Save", click).setIcon(FontAwesome.SAVE);
        menubar.addItem("Cancel", click).setIcon(FontAwesome.ERASER);
    
        Command check = new Command() {
            @Override
            public void menuSelected(MenuItem selectedItem) {
                /*Notification.show(selectedItem.isChecked() ? "Checked"
                        : "Unchecked");*/
            }
        };

        return menubar;
    }
	
	public void SaveWebquote(Tblwebquote webquote){
		try {
			webquote.setCreateDate(new Date());
			TblWebquoteDao.Create(webquote);
			//-------------------------------------
			Notification success = new Notification(
                    "Draft recorded successfully");
            success.setDelayMsec(2000);
            success.setStyleName("bar success small");
            success.setPosition(Position.BOTTOM_CENTER);
            success.show(Page.getCurrent());
            //---------------------------------------
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Notification.show("Error");
			e.printStackTrace();
		}
	}

}
