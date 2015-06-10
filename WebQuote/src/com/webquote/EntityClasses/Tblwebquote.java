package com.webquote.EntityClasses;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the tblwebquote database table.
 * 
 */
@Entity
public class Tblwebquote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="WEBQUOTE_ID")
	private int webquoteId;

	@Column(name="CIRCUIT_ID")
	private String circuitId;

	private String comments;

	@Column(name="CUSTOMER_ID")
	private int customerId;

	@Column(name="CUSTOMER_NAME")
	private String customerName;

    @Temporal( TemporalType.DATE)
	@Column(name="CREATE_DATE")
	private Date createDate;
    
    @Temporal( TemporalType.DATE)
   	@Column(name="EXPIRATION_DATE")
   	private Date expirationDate;

	@Column(name="DEAL_CODE")
	private String dealCode;

	@Column(name="KEY_CODE")
	private int keyCode;
	
	@Column(name="REQUEST_TYPE_ID")
	private int requestType;

	@Column(name="LOCATION_A_ADDRESS")
	private String locationAddress;

	@Column(name="LOCATION_A_DESCRIPTION")
	private String locationDescription;

	@Column(name="LOCATION_A_LATITUDE")
	private String locationLatitude;
	
	@Column(name="LOCATION_A_LONGITUDE")
	private String locationLongitude;

	@Column(name="LOCATION_Z_ADDRESS")
	private String locationZAddress;

	@Column(name="LOCATION_Z_FLOOR")
	private String locationZFloor;
	
	@Column(name="LOCATION_Z_SUITE")
	private String locationZSuite;
	
	@Column(name="LOCATION_Z_ZIP_CODE")
	private String locationZZipCode;
	
	@Column(name="LOCATION_Z_LATITUDE")
	private String locationZLatitude;

	@Column(name="LOCATION_Z_LONGITUDE")
	private String locationzLongitude;
	
	@Column(name="GENERAL_CONTACT_NAME")
	private String generalContactName;
	
	@Column(name="GENERAL_CONTACT_PHONE")
	private String generalContactPhone;
	
	@Column(name="GENERAL_CONTACT_EMAIL")
	private String generalContactEmail;
	
	@Column(name="ONSITE_CONTACT_NAME")
	private String onsiteContactName;
	
	@Column(name="ONSITE_CONTACT_PHONE")
	private String onsiteContactPhone;
	
	@Column(name="ONSITE_CONTACT_EMAIL")
	private String onsiteContactEmail;
	
	//bi-directional many-to-one association to ChangeType
    @ManyToOne
	@JoinColumn(name="CHANGE_TYPE_ID")
	private ChangeType changeType;

	//bi-directional many-to-one association to Country
    @ManyToOne
	@JoinColumn(name="LOCATION_A_COUNTRY_ID")
	private Country country;

	//bi-directional many-to-one association to City
    @ManyToOne
	@JoinColumn(name="LOCATION_A_CITY_ID")
	private City city;
    
    //bi-directional many-to-one association to City
    @ManyToOne
	@JoinColumn(name="LOCATION_Z_COUNTRY_ID")
	private Country locationZCountryId;
	
    //bi-directional many-to-one association to City
    @ManyToOne
	@JoinColumn(name="LOCATION_Z_CITY_ID")
	private  City locationZCityId;

	//bi-directional many-to-one association to WebquoteType
    @ManyToOne
	@JoinColumn(name="WEBQUOTE_TYPE_ID")
	private WebquoteType webquoteType;

	//bi-directional many-to-one association to TopologyType
    @ManyToOne
	@JoinColumn(name="TOPOLOGY_ID")
	private TopologyType topologyType;

	//bi-directional many-to-one association to User
    @ManyToOne
	@JoinColumn(name="REQUESTED_FOR")
	private User user1;

	//bi-directional many-to-one association to User
    @ManyToOne
	@JoinColumn(name="CREATE_USER")
	private User createUser;
    
	//bi-directional many-to-one association to WebquoteDetailProgress
	@OneToMany(mappedBy="tblwebquote")
	private Set<WebquoteDetailProgress> webquoteDetailProgresses;

	//bi-directional many-to-one association to WebquoteDetail
	@OneToMany(mappedBy="tblwebquote")
	private Set<WebquoteDetail> webquoteDetails;

	public Tblwebquote() {
    }

	public int getWebquoteId() {
		return this.webquoteId;
	}

	public void setWebquoteId(int webquoteId) {
		this.webquoteId = webquoteId;
	}

	public String getCircuitId() {
		return this.circuitId;
	}

	public void setCircuitId(String circuitId) {
		this.circuitId = circuitId;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getDealCode() {
		return this.dealCode;
	}

	public void setDealCode(String dealCode) {
		this.dealCode = dealCode;
	}

	public int getKeyCode() {
		return this.keyCode;
	}

	public void setKeyCode(int keyCode) {
		this.keyCode = keyCode;
	}

	public String getLocationAddress() {
		return this.locationAddress;
	}

	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}

	public ChangeType getChangeType() {
		return this.changeType;
	}

	public void setChangeType(ChangeType changeType) {
		this.changeType = changeType;
	}
	
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	public WebquoteType getWebquoteType() {
		return this.webquoteType;
	}

	public void setWebquoteType(WebquoteType webquoteType) {
		this.webquoteType = webquoteType;
	}
	
	public TopologyType getTopologyType() {
		return this.topologyType;
	}

	public void setTopologyType(TopologyType topologyType) {
		this.topologyType = topologyType;
	}
	
	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}
	
	public User getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}
	
	public int getRequestType() {
		return requestType;
	}

	public void setRequestType(int requestType) {
		this.requestType = requestType;
	}

	public Set<WebquoteDetailProgress> getWebquoteDetailProgresses() {
		return this.webquoteDetailProgresses;
	}

	public void setWebquoteDetailProgresses(Set<WebquoteDetailProgress> webquoteDetailProgresses) {
		this.webquoteDetailProgresses = webquoteDetailProgresses;
	}
	
	public Set<WebquoteDetail> getWebquoteDetails() {
		return this.webquoteDetails;
	}

	public void setWebquoteDetails(Set<WebquoteDetail> webquoteDetails) {
		this.webquoteDetails = webquoteDetails;
	}
	
	public String getLocationDescription() {
		return locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	public String getLocationLatitude() {
		return locationLatitude;
	}

	public void setLocationLatitude(String locationLatitude) {
		this.locationLatitude = locationLatitude;
	}

	public String getLocationLongitude() {
		return locationLongitude;
	}

	public void setLocationLongitude(String locationLongitude) {
		this.locationLongitude = locationLongitude;
	}

	public Country getLocationZCountryId() {
		return locationZCountryId;
	}

	public void setLocationZCountryId(Country locationZCountryId) {
		this.locationZCountryId = locationZCountryId;
	}

	public City getLocationZCityId() {
		return locationZCityId;
	}

	public void setLocationZCityId(City locationZCityId) {
		this.locationZCityId = locationZCityId;
	}

	public String getLocationZAddress() {
		return locationZAddress;
	}

	public void setLocationZAddress(String locationZAddress) {
		this.locationZAddress = locationZAddress;
	}

	public String getLocationZFloor() {
		return locationZFloor;
	}

	public void setLocationZFloor(String locationZFloor) {
		this.locationZFloor = locationZFloor;
	}

	public String getLocationZSuite() {
		return locationZSuite;
	}

	public void setLocationZSuite(String locationZSuite) {
		this.locationZSuite = locationZSuite;
	}

	public String getLocationZZipCode() {
		return locationZZipCode;
	}

	public void setLocationZZipCode(String locationZZipCode) {
		this.locationZZipCode = locationZZipCode;
	}

	public String getLocationZLatitude() {
		return locationZLatitude;
	}

	public void setLocationZLatitude(String locationZLatitude) {
		this.locationZLatitude = locationZLatitude;
	}

	public String getLocationzLongitude() {
		return locationzLongitude;
	}

	public void setLocationzLongitude(String locationzLongitude) {
		this.locationzLongitude = locationzLongitude;
	}

	public String getGeneralContactName() {
		return generalContactName;
	}

	public void setGeneralContactName(String generalContactName) {
		this.generalContactName = generalContactName;
	}

	public String getGeneralContactPhone() {
		return generalContactPhone;
	}

	public void setGeneralContactPhone(String generalContactPhone) {
		this.generalContactPhone = generalContactPhone;
	}

	public String getGeneralContactEmail() {
		return generalContactEmail;
	}

	public void setGeneralContactEmail(String generalContactEmail) {
		this.generalContactEmail = generalContactEmail;
	}

	public String getOnsiteContactName() {
		return onsiteContactName;
	}

	public void setOnsiteContactName(String onsiteContactName) {
		this.onsiteContactName = onsiteContactName;
	}

	public String getOnsiteContactPhone() {
		return onsiteContactPhone;
	}

	public void setOnsiteContactPhone(String onsiteContactPhone) {
		this.onsiteContactPhone = onsiteContactPhone;
	}

	public String getOnsiteContactEmail() {
		return onsiteContactEmail;
	}

	public void setOnsiteContactEmail(String onsiteContactEmail) {
		this.onsiteContactEmail = onsiteContactEmail;
	}
	
}