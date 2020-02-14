package com.airline.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Airplane;
import com.airline.models.PlaneStatus;
import com.airlines.beans.AirplaneService;

/**
 * Servlet implementation class addAirplane
 */
@WebServlet("/addAirplane")
public class addAirplane extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private  AirplaneService as;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAirplane() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_plane.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String planeMake = request.getParameter("planeMake");
		String modelName = request.getParameter("modelName");
		String seatingCapacity = request.getParameter("seatingCapacity");
		String status = request.getParameter("status");
		
		Airplane ap = new Airplane();
		
		ap.setPlaneMake(planeMake);
		ap.setModelName(modelName);
		ap.setSeatingCapacity(Integer.parseInt(seatingCapacity));
		ap.setStatus(PlaneStatus.valueOf(status));
		
		as.savePlane(ap);
		
		response.sendRedirect("listAirplane");
	}

}
