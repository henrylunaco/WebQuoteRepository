package com.webquote.Dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.vaadin.data.util.BeanItemContainer;
import com.webquote.EntityClasses.ChangeType;
import com.webquote.EntityClasses.ProductsType;
import com.webquote.FactoryEntity.JpaUtil;

public class ProductsTypeDao {
	
	public static BeanItemContainer<ProductsType> getProductsType()throws Exception{
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q=em.createQuery("select p from ProductsType p");
		ArrayList<ProductsType> res=new ArrayList<ProductsType>(q.getResultList());
		BeanItemContainer<ProductsType> container=new BeanItemContainer<ProductsType>(ProductsType.class);
		container.addAll(res);
		em.clear();
		em.close();
		return container;
	}
}
