/**
 * 
 */
package com.iptf.db;

import org.junit.Test;
import static org.junit.Assert.*;

import com.iptf.db.model.User;

/**
 * @author thomas
 *
 */
public class UserDAOTest {

	@Test
	public void testValidateUser() {
		UserDAO dao = new UserDAO();
	
		User user = dao.validateUser("thomaskj@gmail.com", "password");
		
		assertEquals(2,user.getParish());
		
	}

}
