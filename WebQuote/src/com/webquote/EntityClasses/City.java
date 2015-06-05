package com.webquote.EntityClasses;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the cities database table.
 * 
 */
@Entity
@Table(name="cities")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CITY_ID")
	private int cityId;

	@Column(name="CITY_CODE")
	private String cityCode;

	@Column(name="CITY_NAME")
	private String cityName;

	//bi-directional many-to-one association to Country
    @ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private Country country;

	//bi-directional many-to-one association to Tblwebquote
	@OneToMany(mappedBy="city")
	private Set<Tblwebquote> tblwebquotes;

    public City() {
    }

	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Set<Tblwebquote> getTblwebquotes() {
		return this.tblwebquotes;
	}

	public void setTblwebquotes(Set<Tblwebquote> tblwebquotes) {
		this.tblwebquotes = tblwebquotes;
	}
	
}