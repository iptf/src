package com.iptf.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jInitServlet extends HttpServlet {
	public void init() {
		/*String prefix = getServletContext().getRealPath("/");
		String file = "/log4j.lcf";
		// if the log4j-init-file is not set, then no point in trying
		if(file != null) {
			PropertyConfigurator.configure(prefix+file);
		}*/
		
		InputStream is = this.getClass().getResourceAsStream ("log4j.properties");
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
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.getOutputStream().print("Doing doGet()!!!");
		
		
		init();
		Logger logger = Logger.getLogger(Log4jInitServlet.class);
		logger.error("doGet!!!");
		String prefix = getServletContext().getRealPath("/");
		String file = "log4j.lcf";
		res.getOutputStream().print("Done doGet()!!!::::" + prefix + file);
	}
	
	public static void main(String[] args){
		Log4jInitServlet s = new Log4jInitServlet();
		s.init();
	}

}
