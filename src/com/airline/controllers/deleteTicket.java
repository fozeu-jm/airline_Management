package com.airline.controllers;

import java.io.IOException;

import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Flight;
import com.airlines.beans.TicketService;

/**
 * Servlet implementation class deleteTicket
 */
@WebServlet("/deleteTicket")
public class deleteTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private TicketService ts;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tid = request.getParameter("id");
		if(tid == null) {
			response.sendRedirect("listFlights");
		}else {
			Flight fl = ts.getTicketById(Integer.parseInt(tid)).getFlight();
			ts.deleteTicket(Integer.parseInt(tid));
			
			response.sendRedirect("http://localhost:8080/web2/flightPassengers?id="+fl.getId().toString());
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
