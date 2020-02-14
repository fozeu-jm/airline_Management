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

import com.airline.models.Airplane;
import com.airline.models.PlaneStatus;
import com.airlines.beans.AirplaneService;

/**
 * Servlet implementation class editPlane
 */
@WebServlet("/editPlane")
public class editPlane extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private AirplaneService aps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPlane() {
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
			Airplane ap = aps.getPlaneById(Integer.parseInt(id));
			
			List<String> slist = new ArrayList<String>();
			slist.add(PlaneStatus.Broken_Down.name());
			slist.add(PlaneStatus.Operational.name());
			slist.add(PlaneStatus.Maintenance.name());
			
			request.setAttribute("plane", ap);
			request.setAttribute("slist", slist);
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/editPlane.jsp");
			view.forward(request, response);
			
			 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("planeId");
		String planeMake = request.getParameter("planeMake");
		String modelName = request.getParameter("modelName");
		String seatingCapacity = request.getParameter("seatingCapacity");
		String status = request.getParameter("status");
		
		Airplane ap = aps.getPlaneById(Integer.parseInt(id));
		
		ap.setPlaneMake(planeMake);
		ap.setModelName(modelName);
		ap.setSeatingCapacity(Integer.parseInt(seatingCapacity));
		ap.setStatus(PlaneStatus.valueOf(status));
		
		aps.update(ap);
		
		response.sendRedirect("listAirplane");
	}

}
