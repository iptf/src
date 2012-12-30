package com.iptf.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.iptf.util.PropertyLoader;

public class DBConnectionFactory {
	static Logger logger = Logger.getLogger(DBConnectionFactory.class);

	public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException{
		Connection conn = null;
		logger.debug("Trying to get connection");
		Class.forName("com.mysql.jdbc.Driver");
		PropertyLoader pl = PropertyLoader.getPropertyLoader().getPropertyLoader();
		conn = DriverManager.getConnection(pl.getDbUrl(), pl.getDbUser(),  pl.getDbPassowrd());
		
		logger.debug("connected");
		conn.setAutoCommit(true);
		return conn;
	}
	
	public static void main(String args[]){
		Connection connection = null;
		try {
			connection = DBConnectionFactory.getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Got connection");
		
		try {
			
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
