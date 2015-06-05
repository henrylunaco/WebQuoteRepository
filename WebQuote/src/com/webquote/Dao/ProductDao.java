package com.webquote.Dao;

import com.vaadin.data.util.BeanItemContainer;
import com.webquote.EntityClasses.Product;
import com.webquote.EntityClasses.ProductsType;

public class ProductDao {
	
	public static BeanItemContainer<Product> getAllProductusByType(ProductsType productType)throws Exception{
		BeanItemContainer<Product> container=new BeanItemContainer<Product>(Product.class);
		container.addAll(productType.getProducts());
		return container;
	}

}
