package com.webquote.FactoryEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSI_DB {
	private static String servidor="jdbc:mysql://10.10.1.10:3306/si_be"; //PRODUCTIVO
	//private static String servidor="jdbc:mysql://10.10.1.11:3306/bk_sidb";
	private static String user="hluna"; //PRODUCTIVO
	//private static String user="root";
	private static String pass="admin"; //PRODUCTIVO
	//private static String pass="";
	private static String driver="com.mysql.jdbc.Driver";
	private static Connection conexion;
	
	public ConexionSI_DB(){
		try {
			Class.forName(driver);
			conexion=DriverManager.getConnection(servidor,user,pass);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection(){
		return conexion;
	}
}
