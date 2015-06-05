package com.webquote.FactoryEntity;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
		private static final EntityManagerFactory emf;
		static{
			try{
				emf=Persistence.createEntityManagerFactory("WebQuote");
			}
			catch(Throwable e){
				System.err.println("Fallo la creación inicial del EnityManager: "+e);
				throw new ExceptionInInitializerError();
			}
		}
		public static EntityManagerFactory getEntityManagerFactory(){
			return emf;
		}	
}
