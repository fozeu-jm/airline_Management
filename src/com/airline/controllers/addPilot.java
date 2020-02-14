package com.airline.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Gender;
import com.airline.models.Pilot;
import com.airline.models.PilotRank;
import com.airlines.beans.PiloteService;

/**
 * Servlet implementation class addPilot
 */
@WebServlet("/addPilot")
public class addPilot extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PiloteService ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPilot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> ranklist = new ArrayList<String>();
		ranklist.add(PilotRank.CAPTAIN.name());
		ranklist.add(PilotRank.FIRST_OFFICER.name());
		ranklist.add(PilotRank.JUNIOR_OFFICER.name());
		
		request.setAttribute("ranklist", ranklist);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_pilot.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String pilotLicence = request.getParameter("pilotLicence");
		String rank = request.getParameter("rank");
		String phoneNo = request.getParameter("phoneNo");
		String gender = request.getParameter("gender");
		
		Pilot pi = new Pilot();
		
		pi.setEmail(email);
		pi.setFirstName(firstName);
		pi.setGender(Gender.valueOf(gender));
		pi.setLastName(lastName);
		pi.setPhoneNo(phoneNo);
		pi.setPilotLicence(Long.parseLong(pilotLicence));
		pi.setRank(PilotRank.valueOf(rank));
		
		ps.storePilote(pi);
		
		response.sendRedirect("pilotList");
	}

}
