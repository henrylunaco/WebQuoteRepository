package com.webquote.Dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.vaadin.data.util.BeanItemContainer;
import com.webquote.EntityClasses.Country;
import com.webquote.EntityClasses.Profile;
import com.webquote.EntityClasses.User;
import com.webquote.EntityClasses.WebquoteDetail;
import com.webquote.FactoryEntity.JpaUtil;

public class ProfileDao {
	
	public static void main(String[]args){
		try {
			Profile profile=getSingleProfileId(2);
			System.out.println("->"+ profile.getProfileName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Profile getSingleProfileId(int profileId)throws Exception{
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q=em.createQuery("select p from Profile p where p.profileId=:PRO");
		q.setParameter("PRO", profileId);
		Profile profile=(Profile)q.getSingleResult();
		em.clear();
		em.close();
		return profile;
	}
	
	/*
	public static BeanItemContainer<User> getAllUserProfile(Profile profile)throws Exception{
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q=em.createQuery("select u from User u where u.profile=:PRO");
		q.setParameter("PRO", profile);
		ArrayList<User> res=new ArrayList<User>(q.getResultList());
		BeanItemContainer<User> container=new BeanItemContainer<User>(User.class);
		container.addAll(res);
		em.clear();
		em.close();
		return container;
	}*/
}
