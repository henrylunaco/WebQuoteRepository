package com.webquote.Dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.vaadin.data.util.BeanItemContainer;
import com.webquote.EntityClasses.Country;
import com.webquote.EntityClasses.RequestType;
import com.webquote.FactoryEntity.JpaUtil;

public class RequestTypeDao {
	
	public static BeanItemContainer<RequestType> getAllRequestTypes()throws Exception{
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q=em.createQuery("select r from RequestType r");
		ArrayList<RequestType> res=new ArrayList<RequestType>(q.getResultList());
		BeanItemContainer<RequestType> container=new BeanItemContainer<RequestType>(RequestType.class);
		container.addAll(res);
		em.clear();
		em.close();
		return container;
	}

}
