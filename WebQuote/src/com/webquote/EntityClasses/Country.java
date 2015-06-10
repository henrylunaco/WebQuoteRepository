package com.webquote.EntityClasses;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the countries database table.
 * 
 */
@Entity
@Table(name="countries")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COUNTRY_ID")
	private int countryId;

	@Column(name="COUNTRY_CODE")
	private String countryCode;

	@Column(name="COUNTRY_NAME")
	private String countryName;

	private String region;

	//bi-directional many-to-one association to City
	@OneToMany(mappedBy="country")
	private Set<City> cities;

	//bi-directional many-to-one association to Provider
	@OneToMany(mappedBy="country")
	private Set<Provider> providers;

	//bi-directional many-to-one association to Tblwebquote
	@OneToMany(mappedBy="country")
	private Set<Tblwebquote> tblwebquotes;

    public Country() {
    }

	public int getCountryId() {
		return this.countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Set<City> getCities() {
		return this.cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
	
	public Set<Provider> getProviders() {
		return this.providers;
	}

	public void setProviders(Set<Provider> providers) {
		this.providers = providers;
	}
	
	public Set<Tblwebquote> getTblwebquotes() {
		return this.tblwebquotes;
	}

	public void setTblwebquotes(Set<Tblwebquote> tblwebquotes) {
		this.tblwebquotes = tblwebquotes;
	}
	
}