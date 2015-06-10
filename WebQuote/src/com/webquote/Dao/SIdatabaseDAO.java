package com.webquote.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vaadin.data.util.BeanItemContainer;
import com.webquote.EntityClasses.CableStationSI;
import com.webquote.EntityClasses.CrossconnectSI;
import com.webquote.FactoryEntity.ConexionSI_DB;

public class SIdatabaseDAO {
	public static void main(String[]args){
		try {
			ArrayList<CableStationSI>lista=getListPOPColumbus("PAN");
			for(CableStationSI data : lista){
				System.out.println("POP->"+data.getDescription());
			}
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static CrossconnectSI getCrossconnect(String CID){
		//Procedure to get Crossconnect record
		CrossconnectSI cr=new CrossconnectSI();
		ConexionSI_DB conexion=new ConexionSI_DB();
		Connection con=conexion.getConnection();
		Statement st;
		String sql="SELECT c.`CUSTOMER NAME`,c.`MAIN ORDER STATUS`,c.CKT,c.CID,"+
		"c.`LANDING A`,c.`LANDING Z`,c.CountryA,c.CountryZ,c.bw,c.`CUSTOMER CONTACT`,"+
		"c.`CUSTOMER CONTACT TELEPH`,c.`CUSTOMER CONTACT EMAIL` FROM crossconnect c "+
		"WHERE c.CID='"+CID +"';";
		try {
			st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				 cr.setCID(CID);
				 cr.setCKT(rs.getString(3));
				 cr.setCountryA(rs.getString(7));
				 cr.setCountryZ(rs.getString(8));
				 cr.setCustomerName(rs.getString(1));
				 cr.setLandingA(rs.getString(5));
				 cr.setLandingZ(rs.getString(6));
				 cr.setMain_order_status(rs.getString(2));
				 cr.setBW(rs.getDouble(9));
				 cr.setCustomerContact(rs.getString(10));
				 cr.setCustomerContactPhone(rs.getString(11));
				 cr.setCustomerContactEmail(rs.getString(12));
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cr;
	}
	
	public static ArrayList<CableStationSI> getListPOPColumbus(String country){
		ArrayList<CableStationSI> list=new ArrayList<CableStationSI>();
		ConexionSI_DB conexion=new ConexionSI_DB();
		Connection con=conexion.getConnection();
		Statement st;
		String sql="SELECT c.landing,c.`NODE-TYPE`,c.country,c.`COUNTRY-CODE`,c.description,c.address,"+
		"c.fulladdress,c.latitude,c.longitude FROM `cable station` c WHERE c.country='"+country +"';";
		try {
			st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				 CableStationSI pop=new CableStationSI();
				 pop.setLading(rs.getString(1));
				 pop.setNodeType(rs.getString(2));
				 pop.setCountry(rs.getString(3));
				 pop.setCountryCode(rs.getString(4));
				 pop.setDescription(rs.getString(5));
				 pop.setAddress(rs.getString(6));
				 pop.setFullAddress(rs.getString(7));
				 pop.setLatitude(rs.getString(8));
				 pop.setLongitude(rs.getString(9));
				 list.add(pop);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
