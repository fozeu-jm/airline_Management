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

import com.airline.models.Pilot;
import com.airlines.beans.PiloteService;

/**
 * Servlet implementation class pilotList
 */
@WebServlet("/pilotList")
public class pilotList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private PiloteService ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pilotList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Pilot> pilotlist = ps.getAllPilots();
		request.setAttribute("pilotlist", pilotlist);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/pilot_list.jsp");
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
