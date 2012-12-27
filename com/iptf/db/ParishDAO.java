package com.iptf.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.iptf.db.model.Parish;

public class ParishDAO {
	
	static Logger logger = Logger.getLogger(DBConnectionFactory.class);
	
	public static String LIST_PARISH_SQL = 
			"select parish_id, parish_name, street_address, city, state, zip" +
			" from parish";
	
	public static String FIND_PARISH_BY_ID_SQL = 
			"select parish_id, parish_name, street_address, city, state, zip" +
			" from parish where parish_id=?";
	
	public List<Parish> listParishes(){
		Connection conn = null;
		List <Parish> parishList = new ArrayList<Parish>();
		try {
			conn = DBConnectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(LIST_PARISH_SQL);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Parish parish = new Parish();
				parish.setParishId(rs.getInt("parish_id"));
				parish.setParishName(rs.getString("parish_name"));
				parish.setCity(rs.getString("city"));
				parish.setState(rs.getString("state"));
				parish.setZip(rs.getString("zip"));
				parishList.add(parish);
				
			}
			
		} catch (Exception e) {
			logger.error("Caught Exception: ", e);
			e.printStackTrace();
	
		}
		finally{
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return parishList;
	}
	
	public Parish findParishById(int parishId){
		Connection conn = null;
		Parish parish = null;
		try {
			conn = DBConnectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(FIND_PARISH_BY_ID_SQL);
			stmt.setInt(1, parishId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				parish = new Parish();
				parish.setParishId(rs.getInt("parish_id"));
				parish.setParishName(rs.getString("parish_name"));
				parish.setCity(rs.getString("city"));
				parish.setState(rs.getString("state"));
				parish.setZip(rs.getString("zip"));
			}
			
		} catch (Exception e) {
			logger.error("Caught Exception: ", e);
			e.printStackTrace();
	
		}
		finally{
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return parish;
	}

}
