package com.validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Database.Db_Connection;

public class Validate {
	static Connection con;
	

	public static boolean checkuser(String email, String password) {
		// TODO Auto-generated method stub
   boolean st = false;
		try {
			con = Db_Connection.DBConnect();
			PreparedStatement ps = con
					.prepareStatement("select * from AGL_REG where AGL_REG_EMAIL=? and AGL_REG_PASSWORD=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(email.equals(rs.next())&&password.equals(rs.next()))
			{
				return st;	
			}
			
		} 
		catch (Exception e) {
        System.out.println(e);
		}
		return false;
	}

}
