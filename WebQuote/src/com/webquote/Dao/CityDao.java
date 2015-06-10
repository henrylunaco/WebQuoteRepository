package com.webquote.Dao;

import com.vaadin.data.util.BeanItemContainer;
import com.webquote.EntityClasses.City;
import com.webquote.EntityClasses.Country;

public class CityDao {
	
	public static BeanItemContainer<City> getAllCities(Country country)throws Exception{
		BeanItemContainer<City> container=new BeanItemContainer<City>(City.class);
		container.addAll(country.getCities());
		return container;
	}

}
