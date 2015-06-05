package com.webquote.EntityClasses;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the profiles database table.
 * 
 */
@Entity
@Table(name="profiles")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PROFILE_ID")
	private int profileId;

	private String description;

	private int enable;

	@Column(name="PROFILE_NAME")
	private String profileName;

    public Profile() {
    }

	public int getProfileId() {
		return this.profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEnable() {
		return this.enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public String getProfileName() {
		return this.profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

}