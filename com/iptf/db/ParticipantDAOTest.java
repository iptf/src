/**
 * 
 */
package com.iptf.db;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iptf.db.model.Participant;

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


}
