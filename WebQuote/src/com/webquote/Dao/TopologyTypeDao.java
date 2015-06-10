package com.webquote.Dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.vaadin.data.util.BeanItemContainer;
import com.webquote.EntityClasses.TopologyType;
import com.webquote.FactoryEntity.JpaUtil;

public class TopologyTypeDao {
	public static BeanItemContainer<TopologyType> getTopologyTypes()throws Exception{
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q=em.createQuery("select t from TopologyType t");
		ArrayList<TopologyType> res=new ArrayList<TopologyType>(q.getResultList());
		BeanItemContainer<TopologyType> container=new BeanItemContainer<TopologyType>(TopologyType.class);
		container.addAll(res);
		em.clear();
		em.close();
		return container;
	}
}
