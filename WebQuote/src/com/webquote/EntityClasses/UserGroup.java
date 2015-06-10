package com.webquote.EntityClasses;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the users_groups database table.
 * 
 */
@Entity
@Table(name="users_groups")
public class UserGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GROUP_ID")
	private int groupId;

	private String description;

	private int enable;

	@Column(name="GROUP_MAIL")
	private String groupMail;

	@Column(name="GROUP_NAME")
	private String groupName;

    public UserGroup() {
    }

	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
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

	public String getGroupMail() {
		return this.groupMail;
	}

	public void setGroupMail(String groupMail) {
		this.groupMail = groupMail;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}