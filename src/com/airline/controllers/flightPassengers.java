package com.airline.controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Flight;
import com.airline.models.Ticket;
import com.airlines.beans.FlightService;

/**
 * Servlet implementation class flightPassengers
 */
@WebServlet("/flightPassengers")
public class flightPassengers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FlightService fs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public flightPassengers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fid = request.getParameter("id");
		if(fid == null) {
			response.sendRedirect("listFlights");
		}else {
			Flight fl = fs.getFlightById(Integer.parseInt(fid));
			List<Ticket> tickets = fl.getTickets();
			request.setAttribute("flight", fl);
			request.setAttribute("tickets", tickets);
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/flight_passengers.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
