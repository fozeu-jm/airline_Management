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
import com.airlines.beans.AirplaneService;
import com.airlines.beans.FlightService;

/**
 * Servlet implementation class listFlights
 */
@WebServlet("/listFlights")
public class listFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private FlightService fs;
	@EJB
	private AirplaneService aps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listFlights() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Flight> flist = fs.getAllFlights();
		request.setAttribute("flights", flist);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/list_flights.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
