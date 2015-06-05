package com.webquote.Dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.webquote.EntityClasses.Tblwebquote;
import com.webquote.FactoryEntity.JpaUtil;

public class TblWebquoteDao {
	
	public static void Create(Tblwebquote webquote) throws Exception{
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(webquote);
		em.flush();
		em.getTransaction().commit();
	}
	
}
