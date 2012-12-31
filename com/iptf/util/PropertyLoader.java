package com.iptf.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
	
	public  String dbUser;
	public  String dbPassowrd;
	public  String dbUrl;
	
	
	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPassowrd() {
		return dbPassowrd;
	}

	public void setDbPassowrd(String dbPassowrd) {
		this.dbPassowrd = dbPassowrd;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	private static PropertyLoader pl = null;
	
	
	
	public static PropertyLoader getPropertyLoader() throws IOException{
		if(pl == null){
			pl = new PropertyLoader();
			pl.loadProperties();
		}
		return pl;
	}
	
	public void loadProperties() throws IOException{
		Properties props = 	new Properties();
		InputStream is = this.getClass().getResourceAsStream ("iptf.properties");
		props.load(is);
		dbUser = props.getProperty("db.user");
		dbPassowrd = props.getProperty("db.password");
		dbUrl = props.getProperty("db.url");
		
	}
	public static void main(String[] args){
		try {
			System.out.println(getPropertyLoader().getDbPassowrd());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
