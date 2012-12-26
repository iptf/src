package com.iptf;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

public class DBManager {

	static Connection con =null;
	
	public static Connection  getConnection() throws Exception
	{
		
	try {
		Class.forName("com.mysql.jdbc.Driver");
   	    con=DriverManager.getConnection("jdbc:mysql://localhost/iptfd0_DB0","iptfd0_u2", "iptf@2013");	
	}
	catch(Exception e) {
		e.printStackTrace();
		System.out.println("Exception: " + e.getMessage());
	} 
	

	return con;
	}
	
	public static Connection  getLocalConnection() throws Exception
	{
		
	try {
		Class.forName("com.mysql.jdbc.Driver");   	    	
		con=DriverManager.getConnection("jdbc:mysql://localhost/iptf","conve8_time", "pass1234");
	}
	catch(Exception e) {
		e.printStackTrace();
		System.out.println("Exception: " + e.getMessage());
	} 
	
	/*
	finally 
	{
		try 
		{
		if(con != null)
			con.close();
		} 
		catch(SQLException e) {}
	}
	*/
	return con;
	}
	
	public static void manageUser(User user,String operation)throws Exception{
	    
		Connection con =null;
		PreparedStatement stmt = null;
		Calendar cal = null;
		cal 	= Calendar.getInstance();
		
		try{
	         	con = getConnection();
	         	
	         	if(operation.equals("insert"))
	         	{
	         		stmt = con.prepareStatement("Insert into user (fname, "+ 
	         				"lname, "+
	         				"parish_id, "+
	         				"family_name,"+ 
	         				"father_name,"+ 
	         				"mother_name,"+ 
	         				"street_address,"+ 
	         				"suite,"+ 
	         				"city,"+ 
	         				"state,"+ 
	         				"zip,"+ 
	         				"home_phone,"+ 
	         				"cell_phone,"+ 	  
	         				"parish_india,"+ 
	         				"role_id,"+ 
	         				"last_log_in,"+ 
	         				"gender,"+ 
	         				"description,"+ 
	         				"password,"+
	         				"email,"+
	         				"alt_email"+
	         				") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,ENCODE(?,'ABCDEFG'),?,?)");
	         	}
	         	else
	         	{
	         		stmt = con.prepareStatement("update user set " +
	         				"fname =?,"+ 
	         				"lname=?, "+
	         				"parish_id=?, "+
	         				"family_name=?,"+ 
	         				"father_name=?,"+ 
	         				"mother_name=?,"+ 
	         				"street_address=?,"+ 
	         				"suite=?,"+ 
	         				"city=?,"+ 
	         				"state=?,"+ 
	         				"zip=?,"+ 
	         				"home_phone=?,"+ 
	         				"cell_phone=?,"+ 	         		
	         				"parish_india=?,"+ 
	         				"role_id=?,"+ 
	         				"last_log_in=?,"+ 
	         				"gender=?,"+ 
	         				"description=?,"+ 
	         				"password=ENCODE(?,'ABCDEFG'),email=?,alt_email=? where user_id =?");
	         	}
	     
	        	stmt.setString(1, user.getFirstName());
		        stmt.setString(2, user.getLastName());
		        stmt.setString(3, user.getParish());
		        stmt.setString(4, user.getFamilyName());
		        stmt.setString(5, user.getFatherName());
		        stmt.setString(6, user.getMotherName());
		        stmt.setString(7, user.getStreetAddress());
		        stmt.setString(8, user.getSuite());
		        stmt.setString(9, user.getCity());
		        stmt.setString(10, user.getState());
		        
		        stmt.setString(11, user.getZipCode());		        
		        stmt.setString(12, user.getHomePhone());
		        stmt.setString(13, user.getCellPhone());		        
		        stmt.setString(14, user.getParishIndia());
		        stmt.setString(15, user.getRole());
		        stmt.setTimestamp(16, new Timestamp(cal.getTime().getTime()));
		        stmt.setString(17, user.getGender());
		        stmt.setString(18, user.getDescription());
		        stmt.setString(19, user.getPassword());
		        stmt.setString(20, user.getEmail());
		        
		        if(user.getAltEmail() != null && user.getAltEmail().trim().length()>5){		        
		        	stmt.setString(21, user.getAltEmail());
		        }
		        else
		        {
		        	stmt.setNull(21,java.sql.Types.NULL);
		        }
		        
	         	if(operation.equals("update"))
	         	{
	         		 stmt.setLong(22, user.getUserId());
	         	}
		        
		        stmt.executeUpdate();
	  
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
	    
	  }
	
	public static void manageParticipant(User user,String operation) throws Exception{
	    
		Connection con =null;
		PreparedStatement stmt = null;
		Calendar cal = null;
		cal 	= Calendar.getInstance();
		
		try{
	         	con = getConnection();
	         	
	         	if(operation.equals("insert"))
	         	{
	         		stmt = con.prepareStatement("Insert into participant (fname, "+ 
	         				"lname, "+
	         				"parish_id, "+
	         				"family_name,"+ 
	         				"father_name,"+ 
	         				"mother_name,"+ 
	         				"street_address,"+ 
	         				"suite,"+ 
	         				"city,"+ 
	         				"state,"+ 
	         				"zip,"+ 
	         				"home_phone,"+ 
	         				"cell_phone,"+ 	  
	         				"parish_india,"+ 
	         				"role_id,"+	         				
	         				"gender,"+ 
	         				"description,"+ 	         				
	         				"email,"+
	         				"alt_email"+
	         				") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	         	}
	         	else
	         	{
	         		stmt = con.prepareStatement("update participant set " +
	         				"fname =?,"+ 
	         				"lname=?, "+
	         				"parish_id=?, "+
	         				"family_name=?,"+ 
	         				"father_name=?,"+ 
	         				"mother_name=?,"+ 
	         				"street_address=?,"+ 
	         				"suite=?,"+ 
	         				"city=?,"+ 
	         				"state=?,"+ 
	         				"zip=?,"+ 
	         				"home_phone=?,"+ 
	         				"cell_phone=?,"+ 	         		
	         				"parish_india=?,"+ 
	         				"role_id=?,"+ 	         				
	         				"gender=?,"+ 
	         				"description=?,"+ 
	         				"email=?,alt_email=? where user_id =?");
	         	}
	     
	        	stmt.setString(1, user.getFirstName());
		        stmt.setString(2, user.getLastName());
		        stmt.setString(3, user.getParish());
		        stmt.setString(4, user.getFamilyName());
		        stmt.setString(5, user.getFatherName());
		        stmt.setString(6, user.getMotherName());
		        stmt.setString(7, user.getStreetAddress());
		        stmt.setString(8, user.getSuite());
		        stmt.setString(9, user.getCity());
		        stmt.setString(10, user.getState());
		        
		        stmt.setString(11, user.getZipCode());		        
		        stmt.setString(12, user.getHomePhone());
		        stmt.setString(13, user.getCellPhone());		        
		        stmt.setString(14, user.getParishIndia());
		        stmt.setString(15, user.getRole());		       
		        stmt.setString(16, user.getGender());
		        stmt.setString(17, user.getDescription());		       
		        stmt.setString(18, user.getEmail());
		        
		        if(user.getAltEmail() != null && user.getAltEmail().trim().length()>5){		        
		        	stmt.setString(19, user.getAltEmail());
		        }
		        else
		        {
		        	stmt.setNull(19,java.sql.Types.NULL);
		        }
		        
	         	if(operation.equals("update"))
	         	{
	         		 stmt.setLong(20, user.getUserId());
	         	}
		        
		        stmt.executeUpdate();
	  
	    } catch(Exception e){
	      throw e;
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
	    
	  }
	
public static void testDb(User user) throws Exception{
	    
		Connection con =null;
		PreparedStatement stmt = null;		
		
		try{
	         	con = getConnection();

	         		stmt = con.prepareStatement("Insert into participant (fname, "+ 
	         				"lname, "+
	         				"parish_id, "+	         				
	         				"role_id,"+				
	         				"email"+	         				
	         				") values (?,?,?,?,?)");
	         	
	        	stmt.setString(1, user.getFirstName());
		        stmt.setString(2, user.getLastName());
		        stmt.setString(3, user.getParish());		        
		        stmt.setString(4, user.getRole());	
		        stmt.setString(5, user.getEmail());
		        stmt.executeUpdate();
	  
	    } catch(Exception e){
	      throw e;
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
	    
	  }
	

	public static void main(String args[])
	{
		
		Connection con =null;
		PreparedStatement stmt = null;
		
		/*
		String[] effort = {"1", "2", "3","4","5","0","0"};

		try{	         	         
			DBManager.insertTime("04/07/2010",effort);		
	    } catch(Exception e){
	      System.err.println(e);
	    }
		 */
		
	}
		
}
