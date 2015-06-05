package com.webquote.EntityClasses;

import java.io.Serializable;

public class CableStationSI implements Serializable {
	private String Lading;
	private String NodeType;
	private String Country;
	private String CountryCode;
	private String Description;
	private String Address;
	private String FullAddress;
	private String Latitude;
	private String Longitude;
	
	public CableStationSI(){
		
	}

	public String getLading() {
		return Lading;
	}

	public void setLading(String lading) {
		Lading = lading;
	}

	public String getNodeType() {
		return NodeType;
	}

	public void setNodeType(String nodeType) {
		NodeType = nodeType;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getCountryCode() {
		return CountryCode;
	}

	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getFullAddress() {
		return FullAddress;
	}

	public void setFullAddress(String fullAddress) {
		FullAddress = fullAddress;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
	
	
}
