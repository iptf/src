/**
 * 
 */
package com.iptf.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author thomas
 *
 */
public class ApplicationContextListener implements
		ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		InputStream is = this.getClass().getResourceAsStream ("/log4j.properties");
		Properties props = 	new Properties();
		try {
			props.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PropertyConfigurator.configure(props);
		
		Logger logger = Logger.getLogger(Log4jInitServlet.class);
		logger.error("Initialized!!!");
		
	}

	

}
