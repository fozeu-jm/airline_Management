package com.airline.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Gender;
import com.airline.models.Passenger;
import com.airlines.beans.PassengerService;

/**
 * Servlet implementation class editPassenger
 */
@WebServlet("/editPassenger")
public class editPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private PassengerService ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPassenger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		if(id == null) {
			response.sendRedirect("listpassengers");
			
		}else {
			Passenger p =  ps.getPassengerById(Integer.parseInt(id));
			if(p != null) {
				request.setAttribute("p", p);
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/edit_passenger.jsp");
				view.forward(request, response);
			}else {
				response.sendRedirect("listpassengers");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		Integer passNo = Integer.parseInt(request.getParameter("passNumber"));
		String gender = request.getParameter("gender");
		Integer pid = Integer.parseInt(request.getParameter("pid"));
		//String flightClass = request.getParameter("flightClass");
		
		String dob_raw = request.getParameter("dob");
		String dobArray[] = dob_raw.split("-");
		String day = dobArray[0];
		String month = dobArray[1];
		String year = dobArray[2];
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		cal.set(Calendar.MONTH, Integer.parseInt(month)-1);
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
		Date dob = cal.getTime();
		
		Passenger pass = ps.getPassengerById(pid);
		pass.setFirstName(firstName);
		pass.setLastName(lastName);
		pass.setPassNo(passNo);
		pass.setEmail(email);
		pass.setGender(Gender.valueOf(gender));
		//pass.setFlightClass(FlightClass.valueOf(flightClass));
		pass.setDob(dob);
		
		ps.update(pass);
		
		response.sendRedirect("listpassengers");
	}

}
