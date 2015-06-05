package com.webquote.EntityClasses;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the providers database table.
 * 
 */
@Entity
@Table(name="providers")
public class Provider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PROVIDER_ID")
	private int providerId;

	@Column(name="CONTACT_EMAIL")
	private String contactEmail;

	@Column(name="CONTACT_NAME")
	private String contactName;

	@Column(name="CONTACT_PHONE")
	private String contactPhone;

	@Column(name="PROVIDER_NAME")
	private String providerName;

	@Column(name="TERMS_CONDITIOS")
	private String termsConditios;

	//bi-directional many-to-one association to Country
    @ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private Country country;

	//bi-directional many-to-one association to WebquoteDetail
	@OneToMany(mappedBy="provider")
	private Set<WebquoteDetail> webquoteDetails;

    public Provider() {
    }

	public int getProviderId() {
		return this.providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getProviderName() {
		return this.providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getTermsConditios() {
		return this.termsConditios;
	}

	public void setTermsConditios(String termsConditios) {
		this.termsConditios = termsConditios;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Set<WebquoteDetail> getWebquoteDetails() {
		return this.webquoteDetails;
	}

	public void setWebquoteDetails(Set<WebquoteDetail> webquoteDetails) {
		this.webquoteDetails = webquoteDetails;
	}
	
}