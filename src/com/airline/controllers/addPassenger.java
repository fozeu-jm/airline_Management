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
 * Servlet implementation class addPassenger
 */
@WebServlet(description = "Servlet responsible for passengers operations", urlPatterns = { "/addPassenger" })
public class addPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB 
	private PassengerService ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPassenger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");
		view.forward(request, response);
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
		
		Passenger pass = new Passenger();
		pass.setFirstName(firstName);
		pass.setLastName(lastName);
		pass.setPassNo(passNo);
		pass.setEmail(email);
		pass.setGender(Gender.valueOf(gender));
		//pass.setFlightClass(FlightClass.valueOf(flightClass));
		pass.setDob(dob);
		
		ps.addPassenger(pass);
		
		response.sendRedirect("listpassengers");
		//doGet(request, response);
	}

}
