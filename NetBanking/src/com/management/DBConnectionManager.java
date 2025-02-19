package com.management;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
public class DBConnectionManager {
	
	private static Connection con=null;
	private static Properties props=new Properties();
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		try {
			FileInputStream fis=null;
			fis=new FileInputStream("database.properties");
			props.load(fis);
			Class.forName(props.getProperty("DB_DRIVER_CLASS"));
			con =DriverManager.getConnection(props.getProperty("DB_URL"),props.getProperty("DB_USERNAME"),props.getProperty("DB_PASSWORD"));
			 return con;
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return con;
		
	}

	
}
