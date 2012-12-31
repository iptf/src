package com.iptf.ui.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.iptf.db.ParticipantDAO;
import com.iptf.db.model.Participant;
import com.iptf.db.model.User;

/**
 * Servlet implementation class ParticipantServlet
 */
public class ParticipantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ParticipantServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParticipantServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String nextJSP = "/participant.jsp";
		
		String submitted = request.getParameter("submitted");

		String firstName = "";
		String lastName = "";
		String email = "";
		String altEmail = "";
		String role = "";
		String parish = "";
		String parishIndia = "";

		String familyName = "";
		String fatherName = "";
		String motherName = "";

		String streetAddress = "";
		String suite = "";
		String city = "";
		String state = "";
		String zip = "";

		String homePhone = "";
		String cellPhone = "";

		String gender = "";
		String desc = "";

		Participant participant = null;
		ArrayList objList = null;
		String userId = request.getParameter("user");
		User obj = null;

		if (submitted != null && submitted.equals("true")) {
			try {

				firstName = request.getParameter("firstName");
				lastName = request.getParameter("lastName");
				email = request.getParameter("email");
				altEmail = request.getParameter("altEmail");

				parish = request.getParameter("parish");
				parishIndia = request.getParameter("parishIndia");
				role = "C";

				streetAddress = request.getParameter("streetAddress");
				suite = request.getParameter("suite");
				city = request.getParameter("city");
				state = request.getParameter("state");
				zip = request.getParameter("zip");

				familyName = request.getParameter("familyName");
				fatherName = request.getParameter("fatherName");
				motherName = request.getParameter("motherName");
				desc = request.getParameter("desc");
				gender = request.getParameter("gender");

				homePhone = request.getParameter("homePhone");
				cellPhone = request.getParameter("cellPhone");
				participant = new Participant();
				participant.setFname(firstName);
				participant.setLname(lastName);
				int paridId = Integer.parseInt(parish);
				participant.setParishId(paridId);
				participant.setParishIndia(parishIndia);

				participant.setEmail(email);
				participant.setAltEmail(altEmail);
				participant.setRoleId(role);
				participant.setFamilyName(familyName);
				participant.setFatherName(fatherName);
				participant.setMotherName(motherName);

				participant.setStreetAddress(streetAddress);
				participant.setCity(city);
				participant.setSuite(suite);
				participant.setState(state);
				participant.setZip(zip);

				participant.setHomePhone(homePhone);
				participant.setCellPhone(cellPhone);

				participant.setDescription(desc);
				participant.setGender(gender);
				
				request.setAttribute("participant", participant);

				logger.debug("Adding participant: " + firstName);
				ParticipantDAO dao = new ParticipantDAO();
				dao.addParticipant(participant);

				logger.debug("Added participant: " + firstName);
				
			} catch (Exception e) {
				logger.error("Failed to add participant: ", e);
			}
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,response);
		
	}

}
