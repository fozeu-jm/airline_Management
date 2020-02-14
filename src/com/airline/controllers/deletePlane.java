package com.airline.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.airlines.beans.AirplaneService;

/**
 * Servlet implementation class deletePlane
 */
@WebServlet("/deletePlane")
public class deletePlane extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private AirplaneService aps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletePlane() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null) {
			response.sendRedirect("listAirplane");
		}else {
			aps.deletePlane(Integer.parseInt(id));
			response.sendRedirect("listAirplane");
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
