package com.webquote.EntityClasses;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the units database table.
 * 
 */
@Entity
@Table(name="units")
public class Unit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UNIT_ID")
	private int unitId;

	@Column(name="UNIT_NAME")
	private String unitName;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="unit")
	private Set<Product> products;

    public Unit() {
    }

	public int getUnitId() {
		return this.unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}