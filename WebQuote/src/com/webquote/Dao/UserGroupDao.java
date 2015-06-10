package com.webquote.Dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.vaadin.data.util.BeanItemContainer;
import com.webquote.EntityClasses.Country;
import com.webquote.EntityClasses.UserGroup;
import com.webquote.FactoryEntity.JpaUtil;

public class UserGroupDao {
	
	/*public static BeanItemContainer<Country> getAllCountries()throws Exception{
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q=em.createQuery("select c from Country c");
		ArrayList<Country> res=new ArrayList<Country>(q.getResultList());
		BeanItemContainer<Country> container=new BeanItemContainer<Country>(Country.class);
		container.addAll(res);
		em.clear();
		em.close();
		return container;
	}*/
	
	public static UserGroup getSingleGroup(int COD)throws Exception{
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q=em.createQuery("select u from UsersGroup u where u.groupId=:COD");
		q.setParameter("COD", COD);
		UserGroup res=(UserGroup)(q.getSingleResult());
		em.clear();
		em.close();
		return res;
	}
	
}
