package com.iptf.common;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jInitServlet extends HttpServlet {
	public void init() {
		String prefix = getServletContext().getRealPath("/");
		String file = getInitParameter("log4j-init-file");
		// if the log4j-init-file is not set, then no point in trying
		if(file != null) {
			PropertyConfigurator.configure(prefix+file);
		}
		Logger logger = Logger.getLogger(Log4jInitServlet.class);
		logger.error("Initialized!!!");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.getOutputStream().print("Doing doGet()!!!");
		
		init();
		Logger logger = Logger.getLogger(Log4jInitServlet.class);
		logger.error("doGet!!!");
		String prefix = getServletContext().getRealPath("/");
		String file = getInitParameter("log4j-init-file");
		res.getOutputStream().print("Done doGet()!!!::::" + prefix + file);
	}

}
