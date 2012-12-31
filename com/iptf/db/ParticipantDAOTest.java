/**
 * 
 */
package com.iptf.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iptf.db.model.Participant;
import com.iptf.db.model.ParticipantProgram;

/**
 * @author thomas
 *
 */
public class ParticipantDAOTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.iptf.db.ParticipantDAO#addParticipant(com.iptf.db.model.Participant)}.
	 */
	@Test
	public void testAddParticipant() {
		Participant p = new Participant();
		p.setFname("John");
		p.setLname("Doe");
		p.setParishId(2);
		p.setRoleId("P");
		ParticipantDAO pdao = new ParticipantDAO();
		
		assertTrue(pdao.addParticipant(p) != 0);
	}
	/**
	 * Test method for {@link com.iptf.db.ParticipantDAO#addParticipant(com.iptf.db.model.Participant)}.
	 */
	@Test
	public void testUpdateParticipant() {
		
		ParticipantDAO pdao = new ParticipantDAO();
		Participant p = pdao.findParticipantById(3);
		p.setDescription("Test description...." + System.currentTimeMillis());
		int retVal = pdao.updateParticipant(p);
		assertTrue(retVal == 1);
		Participant p1 = pdao.findParticipantById(3);
		assertEquals(p1.getDescription(),p.getDescription());
	}
	
	@Test
	public void testFindParticipantsByParish(){
		ParticipantDAO pdao = new ParticipantDAO();
		List <Participant> pList = pdao.findParticipantsByParish(2);
		
		assertTrue(pList.size() > 1);
	}
	
	@Test
	public void testFindParticipantById(){
		ParticipantDAO pdao = new ParticipantDAO();
		Participant p = pdao.findParticipantById(3);
		
		assertTrue(p.getParticipantId() == 3);
	}
	
	@Test
	public void testFindParticipantPrograms(){
		ParticipantDAO pdao = new ParticipantDAO();
		List <ParticipantProgram> ppList = pdao.findParticipantPrograms(3);
		
		assertEquals(3,ppList.size());
	}
	
	@Test
	public void testRemoveAllProgramsFromParticipant(){
		ParticipantDAO pdao = new ParticipantDAO();
		pdao.removeAllProgramsFromParticipant(3);
		assertEquals( pdao.findParticipantPrograms(3).size(), 0);
	
		
	}
	
	@Test
	public void testRemoveProgramsFromParticipant(){
		ParticipantDAO pdao = new ParticipantDAO();
		ArrayList<ParticipantProgram> programs = new ArrayList<ParticipantProgram>();
		ParticipantProgram p = new ParticipantProgram();
		p.setParticipantId(3);
		p.setProgramId(4);
		p.setTrackUrl("");
		p.setYear(2013);
		programs.add(p);

		pdao.addProgramsToParticipant(3, programs);
		
		int before = pdao.findParticipantPrograms(3).size();
		pdao.removeProgramsFromParticipant(3, 4);
		
		assertEquals(pdao.findParticipantPrograms(3).size(), before-1);
	}
	
	@Test
	public void testAddProgramsToParticipant() {
		
		ArrayList<ParticipantProgram> programs = new ArrayList<ParticipantProgram>();
		
		
		for (int i=1; i<4; i++){
			ParticipantProgram p = new ParticipantProgram();
			p.setParticipantId(3);
			p.setProgramId(i);
			p.setTrackUrl("");
			p.setYear(2013);
			programs.add(p);
		}
	
		ParticipantDAO pdao = new ParticipantDAO();
		
		pdao.addProgramsToParticipant(3, programs);
		
		assertEquals(3,pdao.findParticipantPrograms(3).size());
		
	}
}
