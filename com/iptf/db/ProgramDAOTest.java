/**
 * 
 */
package com.iptf.db;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iptf.db.model.Program;

/**
 * @author thomas
 *
 */
public class ProgramDAOTest {

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
	 * Test method for {@link com.iptf.db.ProgramDAO#findProgramById(int)}.
	 */
	@Test
	public void testFindProgramById() {
		ProgramDAO dao = new ProgramDAO();
		Program p = dao.findProgramById(1);
		assertNotNull(p);
		assertEquals(1, p.getProgramId());
		
	}
	
	/**
	 * Test method for {@link com.iptf.db.ProgramDAO#listPrograms()}.
	 */
	@Test
	public void testListPrograms() {
		ProgramDAO dao = new ProgramDAO();
		List<Program> pList = dao.listPrograms();
		assertNotNull(pList);
		assertTrue(1 < pList.size());
		
	}

}
