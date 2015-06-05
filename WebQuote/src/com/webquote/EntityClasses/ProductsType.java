package com.webquote.EntityClasses;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the products_types database table.
 * 
 */
@Entity
@Table(name="products_types")
public class ProductsType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRODUCT_TYPE_ID")
	private int productTypeId;

	@Column(name="PRODUCT_TYPE_NAME")
	private String productTypeName;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="productsType")
	private Set<Product> products;

    public ProductsType() {
    }

	public int getProductTypeId() {
		return this.productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName() {
		return this.productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}