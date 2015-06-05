package com.webquote.EntityClasses;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the webquote_details database table.
 * 
 */
@Entity
@Table(name="webquote_details")
public class WebquoteDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DETAIL_ID")
	private int detailId;

	private double capex;

	@Column(name="CAPEX_DEDICATED")
	private double capexDedicated;

	@Column(name="CONTRACT_TERM")
	private int contractTerm;

	private String markup;

	private double mrc;

	private double nrc;

	private double opex;

	private int quantity;

	private String remarks;

	@Column(name="TARGET_DELIVERY")
	private int targetDelivery;

	//bi-directional many-to-one association to Tblwebquote
    @ManyToOne
	@JoinColumn(name="WEBQUOTE_ID")
	private Tblwebquote tblwebquote;

	//bi-directional many-to-one association to Product
    @ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;

	//bi-directional many-to-one association to Provider
    @ManyToOne
	@JoinColumn(name="PROVIDERS_ID")
	private Provider provider;
    
    //bi-directional many-to-one association to Provider
    @ManyToOne
	@JoinColumn(name="LOCATION_COUNTRY_ID")
	private Country locationCountryID;
    
    //bi-directional many-to-one association to Provider
    @ManyToOne
	@JoinColumn(name="LOCATION_CITY_ID")
	private City locationCityID;
    
    @Column(name="LOCATION_ADDRESS")
	private String locationAddress;
    
    @Column(name="LOCATION_FLOOR")
	private String locationFloor;
    
    @Column(name="LOCATION_SUITE")
	private String locationSUITE;
    
    @Column(name="LOCATION_ZIP_CODE")
	private String locationZipCode;
    
    @Column(name="LOCATION_LATITUDE")
	private String locationLatitude;
    
    @Column(name="LOCATION_LONGITUDE")
	private String locationLongitude;

    @Column(name="LOCATION_TYPE")
	private int locationType;
    
    public WebquoteDetail() {
    }

	public int getDetailId() {
		return this.detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public double getCapex() {
		return this.capex;
	}

	public void setCapex(double capex) {
		this.capex = capex;
	}

	public double getCapexDedicated() {
		return this.capexDedicated;
	}

	public void setCapexDedicated(double capexDedicated) {
		this.capexDedicated = capexDedicated;
	}

	public int getContractTerm() {
		return this.contractTerm;
	}

	public void setContractTerm(int contractTerm) {
		this.contractTerm = contractTerm;
	}

	public String getMarkup() {
		return this.markup;
	}

	public void setMarkup(String markup) {
		this.markup = markup;
	}

	public double getMrc() {
		return this.mrc;
	}

	public void setMrc(double mrc) {
		this.mrc = mrc;
	}

	public double getNrc() {
		return this.nrc;
	}

	public void setNrc(double nrc) {
		this.nrc = nrc;
	}

	public double getOpex() {
		return this.opex;
	}

	public void setOpex(double opex) {
		this.opex = opex;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getTargetDelivery() {
		return this.targetDelivery;
	}

	public void setTargetDelivery(int targetDelivery) {
		this.targetDelivery = targetDelivery;
	}

	public Tblwebquote getTblwebquote() {
		return this.tblwebquote;
	}

	public void setTblwebquote(Tblwebquote tblwebquote) {
		this.tblwebquote = tblwebquote;
	}
	
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Provider getProvider() {
		return this.provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Country getLocationCountryID() {
		return locationCountryID;
	}

	public void setLocationCountryID(Country locationCountryID) {
		this.locationCountryID = locationCountryID;
	}

	public City getLocationCityID() {
		return locationCityID;
	}

	public void setLocationCityID(City locationCityID) {
		this.locationCityID = locationCityID;
	}

	public String getLocationAddress() {
		return locationAddress;
	}

	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}

	public String getLocationFloor() {
		return locationFloor;
	}

	public void setLocationFloor(String locationFloor) {
		this.locationFloor = locationFloor;
	}

	public String getLocationSUITE() {
		return locationSUITE;
	}

	public void setLocationSUITE(String locationSUITE) {
		this.locationSUITE = locationSUITE;
	}

	public String getLocationZipCode() {
		return locationZipCode;
	}

	public void setLocationZipCode(String locationZipCode) {
		this.locationZipCode = locationZipCode;
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

	public int getLocationType() {
		return locationType;
	}

	public void setLocationType(int locationType) {
		this.locationType = locationType;
	}
	
}