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

public class UserDao {
	
	public static void main(String[]args){
		try {
			User user=getSingleUser("hluna");
			System.out.println("->"+ user.getLastName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static User getSingleUser(String userCode)throws Exception{
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q=em.createQuery("select u from User u where u.userCode=:COD");
		q.setParameter("COD", userCode);
		User user=(User)q.getSingleResult();
		em.clear();
		em.close();
		return user;
	}
	
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
	}
}
