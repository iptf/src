package com.iptf.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.iptf.db.model.Program;

public class ProgramDAO {
	
	static Logger logger = Logger.getLogger(DBConnectionFactory.class);
	
	private String FIND_PROGRAM_BY_ID_SQL = "select program_id, category_id, program_name, program_desc, group_flag" +
			" from program where program_id=?";
	
	private String LIST_PROGRAMS_SQL = "select program_id, category_id, program_name, program_desc, group_flag" +
			" from program";
	
	public Program findProgramById(int programId){
		Connection conn = null;
		Program p = null;
		try {
			conn = DBConnectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(FIND_PROGRAM_BY_ID_SQL);
			stmt.setInt(1, programId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				p = new Program();
				p.setProgramId(rs.getInt("program_id"));
				p.setCategoryId(rs.getInt("category_id"));
				p.setProgramName(rs.getString("program_name"));
				p.setDescription(rs.getString("program_desc"));
				p.setGroupFlag(rs.getString("group_flag"));
				
			}
			
		} catch (Exception e) {
			logger.error("Caught Exception: ", e);
			e.printStackTrace();
	
		}
		
		return p;

	}
	
	public List <Program> listPrograms(){
		Connection conn = null;
		List <Program> pList = new ArrayList<Program>();
		try {
			conn = DBConnectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(LIST_PROGRAMS_SQL);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Program p = new Program();
				p.setProgramId(rs.getInt("program_id"));
				p.setCategoryId(rs.getInt("category_id"));
				p.setProgramName(rs.getString("program_name"));
				p.setDescription(rs.getString("program_desc"));
				p.setGroupFlag(rs.getString("group_flag"));
				pList.add(p);
			}
			
		} catch (Exception e) {
			logger.error("Caught Exception: ", e);
			e.printStackTrace();
	
		}
		
		return pList;

	}
	
}
