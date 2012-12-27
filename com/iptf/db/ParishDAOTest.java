package com.iptf.db;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.iptf.db.model.Parish;

public class ParishDAOTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindParishById() {
		ParishDAO dao = new ParishDAO();
		Parish p = dao.findParishById(2);
		assertNotNull(p);
		assertEquals(2, p.getParishId());
	}

}
