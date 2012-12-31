package com.iptf.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iptf.db.model.User;

public class UserDAO {
	
private static final String SELECT_USER_SQL = "SELECT DECODE(PASSWORD,'ABCDEFG')," +
				"role_id,fname,lname,parish,parish_name FROM user u," +
				"parish p where email=? and u.parish= p.parish_id";

public User validateUser(String email,String password){
	    
		Connection con =null;
		PreparedStatement stmt = null;	
		User user = null;
		
		try{
	         	con = DBConnectionFactory.getConnection();	         	
	         	stmt = con.prepareStatement(SELECT_USER_SQL);	     
	         	stmt.setString(1, email);
	            ResultSet rs = stmt.executeQuery();
	            String pass = null;
	            
	            while(rs.next()){	
	            	
	            	pass = rs.getString(1);	   
		            if(pass.equals(password))
		            {
		            	user = new User();
		            	user.setEmail(email);
		            	user.setFirstName(rs.getString(3));
		            	user.setLastName(rs.getString(4));
		            	user.setRole(rs.getString(2));	
		            	user.setParish(rs.getInt(5));
		            	user.setParishName(rs.getString(6));
		            }
	            }	  
	    } catch(Exception e){
	      System.err.println(e);
	    }
		finally 
		{	
			try 
			{				
				stmt.close();
				if(con != null){
					con.close();
				}
			} 
			catch(SQLException e) {}
		}	 
		 return user;     
	    
	  }	

}
