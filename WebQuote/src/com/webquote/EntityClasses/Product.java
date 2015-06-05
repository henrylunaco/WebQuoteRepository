package com.webquote.EntityClasses;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRODUCT_ID")
	private int productId;

	private String description;

	@Column(name="PRODUCT_NAME")
	private String productName;

	//bi-directional many-to-one association to Unit
    @ManyToOne
	@JoinColumn(name="UNIT_ID")
	private Unit unit;

	//bi-directional many-to-one association to ProductsType
    @ManyToOne
	@JoinColumn(name="PRODUCT_TYPE_ID")
	private ProductsType productsType;

	//bi-directional many-to-one association to WebquoteDetail
	@OneToMany(mappedBy="product")
	private Set<WebquoteDetail> webquoteDetails;

    public Product() {
    }

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Unit getUnit() {
		return this.unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	public ProductsType getProductsType() {
		return this.productsType;
	}

	public void setProductsType(ProductsType productsType) {
		this.productsType = productsType;
	}
	
	public Set<WebquoteDetail> getWebquoteDetails() {
		return this.webquoteDetails;
	}

	public void setWebquoteDetails(Set<WebquoteDetail> webquoteDetails) {
		this.webquoteDetails = webquoteDetails;
	}
	
}