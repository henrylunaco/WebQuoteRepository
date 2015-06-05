package com.webquote.EntityClasses;

//This class is using to access SI database and execute query on Crossconnect table,
//the result is loading in a Object memory.

public class CrossconnectSI {
	
	private String CID;
	private String CustomerName;
	private String Main_order_status;
	private String LandingA;
	private String LandingZ;
	private String CKT;
	private String CountryA;
	private String CountryZ;
	private Double BW;
	private String CustomerContact;
	private String CustomerContactPhone;
	private String CustomerContactEmail;
	
	
	public String getCustomerContact() {
		return CustomerContact;
	}

	public void setCustomerContact(String customerContact) {
		CustomerContact = customerContact;
	}

	public String getCustomerContactPhone() {
		return CustomerContactPhone;
	}

	public void setCustomerContactPhone(String customerContactPhone) {
		CustomerContactPhone = customerContactPhone;
	}

	public String getCustomerContactEmail() {
		return CustomerContactEmail;
	}

	public void setCustomerContactEmail(String customerContactEmail) {
		CustomerContactEmail = customerContactEmail;
	}

	public CrossconnectSI(){
		
	}

	public String getCID() {
		return CID;
	}

	public void setCID(String cID) {
		CID = cID;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getMain_order_status() {
		return Main_order_status;
	}

	public void setMain_order_status(String main_order_status) {
		Main_order_status = main_order_status;
	}

	public String getLandingA() {
		return LandingA;
	}

	public void setLandingA(String landingA) {
		LandingA = landingA;
	}

	public String getLandingZ() {
		return LandingZ;
	}

	public void setLandingZ(String landingZ) {
		LandingZ = landingZ;
	}

	public String getCKT() {
		return CKT;
	}

	public void setCKT(String cKT) {
		CKT = cKT;
	}

	public String getCountryA() {
		return CountryA;
	}

	public void setCountryA(String countryA) {
		CountryA = countryA;
	}

	public String getCountryZ() {
		return CountryZ;
	}

	public void setCountryZ(String countryZ) {
		CountryZ = countryZ;
	}

	public Double getBW() {
		return BW;
	}

	public void setBW(Double bW) {
		BW = bW;
	}

}
