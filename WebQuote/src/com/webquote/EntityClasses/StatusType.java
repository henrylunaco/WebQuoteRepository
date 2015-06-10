package com.webquote.EntityClasses;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the status_types database table.
 * 
 */
@Entity
@Table(name="status_types")
public class StatusType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STATUS_TYPE_ID")
	private int statusTypeId;

	private String description;

	@Column(name="STATUS_FLAG")
	private String statusFlag;

	@Column(name="STATUS_TYPE_NAME")
	private String statusTypeName;

    public StatusType() {
    }

	public int getStatusTypeId() {
		return this.statusTypeId;
	}

	public void setStatusTypeId(int statusTypeId) {
		this.statusTypeId = statusTypeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatusFlag() {
		return this.statusFlag;
	}

	public void setStatusFlag(String statusFlag) {
		this.statusFlag = statusFlag;
	}

	public String getStatusTypeName() {
		return this.statusTypeName;
	}

	public void setStatusTypeName(String statusTypeName) {
		this.statusTypeName = statusTypeName;
	}

}