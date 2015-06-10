package com.webquote.EntityClasses;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the webquote_type database table.
 * 
 */
@Entity
@Table(name="webquote_type")
public class WebquoteType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="WEQUOTE_TYPE_ID")
	private int wequoteTypeId;

	@Column(name="WEBQUOTE_TYPE_NAME")
	private String webquoteTypeName;

	//bi-directional many-to-one association to Tblwebquote
	@OneToMany(mappedBy="webquoteType")
	private Set<Tblwebquote> tblwebquotes;

    public WebquoteType() {
    }

	public int getWequoteTypeId() {
		return this.wequoteTypeId;
	}

	public void setWequoteTypeId(int wequoteTypeId) {
		this.wequoteTypeId = wequoteTypeId;
	}

	public String getWebquoteTypeName() {
		return this.webquoteTypeName;
	}

	public void setWebquoteTypeName(String webquoteTypeName) {
		this.webquoteTypeName = webquoteTypeName;
	}

	public Set<Tblwebquote> getTblwebquotes() {
		return this.tblwebquotes;
	}

	public void setTblwebquotes(Set<Tblwebquote> tblwebquotes) {
		this.tblwebquotes = tblwebquotes;
	}
	
}