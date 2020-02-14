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

import com.airline.models.Flight;
import com.airline.models.FlightClass;
import com.airline.models.Passenger;
import com.airline.models.Ticket;
import com.airlines.beans.FlightService;
import com.airlines.beans.PassengerService;
import com.airlines.beans.TicketService;

/**
 * Servlet implementation class addTicket
 */
@WebServlet("/addTicket")
public class addTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PassengerService ps;

	@EJB
	private FlightService fs;

	@EJB
	private TicketService ts;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addTicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String f_id = request.getParameter("id");
		if (f_id == null) {
			response.sendRedirect("listFlights");
		} else {
			Flight fl = fs.getFlightById(Integer.parseInt(f_id));
			List<Passenger> pslist = ps.getAllPassengers();
			List<String> clist = new ArrayList<String>();
			clist.add(FlightClass.Economy.name());
			clist.add(FlightClass.Business.name());
			clist.add(FlightClass.First.name());
			request.setAttribute("flight", fl);
			request.setAttribute("pslist", pslist);
			request.setAttribute("clist", clist);

			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_ticket.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flId = request.getParameter("flightId");
		String passId = request.getParameter("passId");
		String price = request.getParameter("price");
		String flightClass = request.getParameter("flightClass");

		Flight fl = fs.getFlightById(Integer.parseInt(flId));
		Passenger pass = ps.getPassengerById(Integer.parseInt(passId));

		Ticket tick = new Ticket();
		tick.setPrice(Double.parseDouble(price));
		tick.setFlightClass(FlightClass.valueOf(flightClass));
		tick.setPassenger(pass);
		tick.setFlight(fl);

		List<Ticket> passticks = pass.getTickets();
		passticks.add(tick);

		List<Ticket> flightticks = fl.getTickets();
		flightticks.add(tick);

		ts.register(tick);
		
		String baseUrl = getBaseUrl(request);
		
		response.sendRedirect(baseUrl+"/flightPassengers?id="+fl.getId().toString());
	}
	
	public static String getBaseUrl(HttpServletRequest request) {
	    String scheme = request.getScheme() + "://";
	    String serverName = request.getServerName();
	    String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
	    String contextPath = request.getContextPath();
	    return scheme + serverName + serverPort + contextPath;
	  }

}
