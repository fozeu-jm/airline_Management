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

import com.airline.models.Passenger;
import com.airlines.beans.PassengerService;

/**
 * Servlet implementation class listpassengers
 */
@WebServlet("/listpassengers")
public class listpassengers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private PassengerService ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listpassengers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Passenger> plist = ps.getAllPassengers();
		request.setAttribute("plist", plist);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/listPassengers.jsp");
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
