package com.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Db_Connection {
  
	public static Connection DBConnect(){
		
		Connection con = null;
		try{
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			con=DriverManager.getConnection("jdbc:db2://192.168.0.36:50000/TRAINEE","db2admin","dba@2016");
			System.out.println("Connected");	
		}
		catch(Exception e){
			System.out.println(e);
		}
		return con;
	}
	
		
}
