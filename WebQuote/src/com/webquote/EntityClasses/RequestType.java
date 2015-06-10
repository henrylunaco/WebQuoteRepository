package com.webquote.EntityClasses;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the request_types database table.
 * 
 */
@Entity
@Table(name="request_types")
public class RequestType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="REQUEST_TYPE_ID")
	private int requestTypeId;

	@Column(name="REQUEST_TYPE_NAME")
	private String requestTypeName;

    public RequestType() {
    }

	public int getRequestTypeId() {
		return this.requestTypeId;
	}

	public void setRequestTypeId(int requestTypeId) {
		this.requestTypeId = requestTypeId;
	}

	public String getRequestTypeName() {
		return this.requestTypeName;
	}

	public void setRequestTypeName(String requestTypeName) {
		this.requestTypeName = requestTypeName;
	}

}