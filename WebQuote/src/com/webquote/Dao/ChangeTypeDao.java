package com.webquote.Dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.vaadin.data.util.BeanItemContainer;
import com.webquote.EntityClasses.ChangeType;
import com.webquote.EntityClasses.Country;
import com.webquote.FactoryEntity.JpaUtil;

public class ChangeTypeDao {
	public static BeanItemContainer<ChangeType> getChangeTypes()throws Exception{
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q=em.createQuery("select c from ChangeType c");
		ArrayList<ChangeType> res=new ArrayList<ChangeType>(q.getResultList());
		BeanItemContainer<ChangeType> container=new BeanItemContainer<ChangeType>(ChangeType.class);
		container.addAll(res);
		em.clear();
		em.close();
		return container;
	}
}
