package com.iptf.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.iptf.db.model.Participant;
import com.iptf.db.model.ParticipantProgram;

public class ParticipantDAO {
	static Logger logger = Logger.getLogger(DBConnectionFactory.class);
	
	public static final String INSERT_PARTICIPANT_SQL = " insert into participant " +
			"(fname, lname, parish_id, family_name, father_name, mother_name, street_address, suite, " +
			"city, state, zip, home_phone, cell_phone, parish_india, role_id, gender, description, email, alt_email, photo_url)" +
			" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static final String UPDATE_PARTICIPANT_SQL = "update participant set " +
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
				"email=?,alt_email=?, photo_url=?" +
				" where participant_id =?";
	
	public final String LAST_INDERT_ID_SQL = "SELECT LAST_INSERT_ID()";
	
	public final String FIND_PARTICIPANT_BY_PARISH_ID_SQL = "select participant_id, fname, lname, parish_id, family_name, father_name, mother_name, street_address, suite, " +
			"city, state, zip, home_phone, cell_phone, parish_india, role_id, gender, description, email, alt_email, photo_url " +
			" from participant where parish_id=?";
	
	public final String FIND_PARTICIPANT_BY_ID_SQL = "select participant_id, fname, lname, parish_id, family_name, father_name, mother_name, street_address, suite, " +
			"city, state, zip, home_phone, cell_phone, parish_india, role_id, gender, description, email, alt_email, photo_url " +
			" from participant where participant_id=?";
 
	public final String INSERT_PARTICIPANT_PGM_SQL = "insert into participant_program " +
			" values(?,?,?,?)";
	
	public int addParticipant(Participant participant){
			
		int returnValue = 0;
		
		String parish = "";
		Connection conn = null;
		try {
			conn = DBConnectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(INSERT_PARTICIPANT_SQL);
			stmt.setString(1, participant.getFname());
			stmt.setString(2, participant.getLname());
			stmt.setInt(3, participant.getParishId());
			stmt.setString(4, participant.getFamilyName());
			stmt.setString(5, participant.getFatherName());
			stmt.setString(6, participant.getMotherName());
			stmt.setString(7, participant.getStreetAddress());
			stmt.setString(8, participant.getSuite());
			stmt.setString(9, participant.getState());
			stmt.setString(10, participant.getZip());
			stmt.setString(11, participant.getHomePhone());
			stmt.setString(12, participant.getCellPhone());
			stmt.setString(13, participant.getHomePhone());
			stmt.setString(14, participant.getParishIndia());
			stmt.setString(15, participant.getRoleId());
			stmt.setString(16, participant.getGender());
			stmt.setString(17, participant.getDescription());
			stmt.setString(18, participant.getEmail());
			stmt.setString(19, participant.getAltEmail());
			stmt.setString(20, participant.getPhotoUrl());
			
			int result = stmt.executeUpdate();
			if(result == 1){
				PreparedStatement stmt2 = conn.prepareStatement(LAST_INDERT_ID_SQL);
				ResultSet rs = stmt2.executeQuery();
				if(rs.next()){
					returnValue = rs.getInt(1);
				}
	
				
			}
			
			
		} catch (Exception e) {
			logger.error("Caught Exception: ", e);
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
	
		return returnValue;
		
	}
	
	public Participant findParticipantById(int participantId){
		Connection conn = null;
		Participant p = null;
		try {
			conn = DBConnectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(FIND_PARTICIPANT_BY_ID_SQL);
			stmt.setInt(1, participantId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				p = new Participant();
				int i=1;
				p.setParticipantId(rs.getInt(i++));
				p.setFname(rs.getString(i++));
				p.setLname(rs.getString(i++));
				p.setParishId(rs.getInt(i++));
				p.setFamilyName(rs.getString(i++));
				p.setFatherName(rs.getString(i++));
				p.setMotherName(rs.getString(i++));
				p.setStreetAddress(rs.getString(i++));
				p.setSuite(rs.getString(i++));
				p.setCity(rs.getString(i++));
				p.setState(rs.getString(i++));
				p.setZip(rs.getString(i++));
				p.setHomePhone(rs.getString(i++));
				p.setCellPhone(rs.getString(i++));
				p.setParishIndia(rs.getString(i++));
				p.setRoleId(rs.getString(i++));
				p.setGender(rs.getString(i++));
				p.setDescription(rs.getString(i++));
				p.setEmail(rs.getString(i++));
				p.setAltEmail(rs.getString(i++));
				p.setPhotoUrl(rs.getString(i++));
				
				
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
		return p;
	}
	
	public List<Participant> findParticipantsByParish(int parishId){
		Connection conn = null;
		List <Participant> participantList = new ArrayList<Participant>();
		try {
			conn = DBConnectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(FIND_PARTICIPANT_BY_PARISH_ID_SQL);
			stmt.setInt(1, parishId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Participant p = new Participant();
				int i=1;
				p.setParticipantId(rs.getInt(i++));
				p.setFname(rs.getString(i++));
				p.setLname(rs.getString(i++));
				p.setParishId(rs.getInt(i++));
				p.setFamilyName(rs.getString(i++));
				p.setFatherName(rs.getString(i++));
				p.setMotherName(rs.getString(i++));
				p.setStreetAddress(rs.getString(i++));
				p.setSuite(rs.getString(i++));
				p.setCity(rs.getString(i++));
				p.setState(rs.getString(i++));
				p.setZip(rs.getString(i++));
				p.setHomePhone(rs.getString(i++));
				p.setCellPhone(rs.getString(i++));
				p.setParishIndia(rs.getString(i++));
				p.setRoleId(rs.getString(i++));
				p.setGender(rs.getString(i++));
				p.setDescription(rs.getString(i++));
				p.setEmail(rs.getString(i++));
				p.setAltEmail(rs.getString(i++));
				p.setPhotoUrl(rs.getString(i++));
				participantList.add(p);
				
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
		
		return participantList;
	}
	

	public int updateParticipant(Participant participant){
		
		int returnValue = 0;
		
		Connection conn = null;
		try {
			conn = DBConnectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(UPDATE_PARTICIPANT_SQL);
			stmt.setString(1, participant.getFname());
			stmt.setString(2, participant.getLname());
			stmt.setInt(3, participant.getParishId());
			stmt.setString(4, participant.getFamilyName());
			stmt.setString(5, participant.getFatherName());
			stmt.setString(6, participant.getMotherName());
			stmt.setString(7, participant.getStreetAddress());
			stmt.setString(8, participant.getSuite());
			stmt.setString(9, participant.getState());
			stmt.setString(10, participant.getZip());
			stmt.setString(11, participant.getHomePhone());
			stmt.setString(12, participant.getCellPhone());
			stmt.setString(13, participant.getHomePhone());
			stmt.setString(14, participant.getParishIndia());
			stmt.setString(15, participant.getRoleId());
			stmt.setString(16, participant.getGender());
			stmt.setString(17, participant.getDescription());
			stmt.setString(18, participant.getEmail());
			stmt.setString(19, participant.getAltEmail());
			stmt.setString(20, participant.getPhotoUrl());
			
			stmt.setInt(21, participant.getParticipantId());
			
			returnValue = stmt.executeUpdate();
			
			
			
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
	
		return returnValue;
		
	}
	
	public void addProgramsToParticipant(int participantId, List<ParticipantProgram> programs ){
		
		
		String parish = "";
		Connection conn = null;
		try {
			conn = DBConnectionFactory.getConnection();
			
			
			
			PreparedStatement stmt = conn.prepareStatement(INSERT_PARTICIPANT_PGM_SQL);
			
			for(ParticipantProgram program:programs){
			
				stmt.setInt(1, participantId);
				stmt.setInt(2, program.getProgramId());
				stmt.setString(3, program.getTrackUrl());
				stmt.setInt(4, program.getYear());
				stmt.addBatch();
			}
	
			
			int[] result = stmt.executeBatch();
			
			
			
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
	}

}
