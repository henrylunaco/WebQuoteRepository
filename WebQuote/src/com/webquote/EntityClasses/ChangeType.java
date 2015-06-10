package com.webquote.EntityClasses;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the change_type database table.
 * 
 */
@Entity
@Table(name="change_type")
public class ChangeType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CHANGE_TYPE_ID")
	private int changeTypeId;

	private String description;

	private String name;

	//bi-directional many-to-one association to Tblwebquote
	@OneToMany(mappedBy="changeType")
	private Set<Tblwebquote> tblwebquotes;

    public ChangeType() {
    }

	public int getChangeTypeId() {
		return this.changeTypeId;
	}

	public void setChangeTypeId(int changeTypeId) {
		this.changeTypeId = changeTypeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Tblwebquote> getTblwebquotes() {
		return this.tblwebquotes;
	}

	public void setTblwebquotes(Set<Tblwebquote> tblwebquotes) {
		this.tblwebquotes = tblwebquotes;
	}
	
}