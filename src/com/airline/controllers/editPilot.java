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
 * Servlet implementation class editPilot
 */
@WebServlet("/editPilot")
public class editPilot extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	PiloteService ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPilot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null) {
			response.sendRedirect("pilotList");
		}else {
			Pilot pi = ps.getPilotById(Integer.parseInt(id));
			
			request.setAttribute("pilot", pi);
			
			List<String> ranklist = new ArrayList<String>();
			ranklist.add(PilotRank.CAPTAIN.name());
			ranklist.add(PilotRank.FIRST_OFFICER.name());
			ranklist.add(PilotRank.JUNIOR_OFFICER.name());
			
			request.setAttribute("ranklist", ranklist);
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/edit_pilot.jsp");
			view.forward(request, response);
		}
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
		String pid = request.getParameter("pid");
		
		Pilot pi = ps.getPilotById(Integer.parseInt(pid));
		
		pi.setEmail(email);
		pi.setFirstName(firstName);
		pi.setGender(Gender.valueOf(gender));
		pi.setLastName(lastName);
		pi.setPhoneNo(phoneNo);
		pi.setPilotLicence(Long.parseLong(pilotLicence));
		pi.setRank(PilotRank.valueOf(rank));
		
		ps.editPilote(pi);
		
		response.sendRedirect("pilotList");
	}

}
