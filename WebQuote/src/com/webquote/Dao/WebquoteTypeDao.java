package com.webquote.Dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.vaadin.data.util.BeanItemContainer;
import com.webquote.EntityClasses.WebquoteType;
import com.webquote.FactoryEntity.JpaUtil;

public class WebquoteTypeDao {
	
	public static BeanItemContainer<WebquoteType> geWebquoteTypes()throws Exception{
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q=em.createQuery("select w from WebquoteType w");
		ArrayList<WebquoteType> res=new ArrayList<WebquoteType>(q.getResultList());
		BeanItemContainer<WebquoteType> container=new BeanItemContainer<WebquoteType>(WebquoteType.class);
		container.addAll(res);
		em.clear();
		em.close();
		return container;
	}

}
