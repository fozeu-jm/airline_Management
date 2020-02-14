package com.airline.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airlines.beans.PassengerService;

/**
 * Servlet implementation class deletePassenger
 */
@WebServlet("/deletePassenger")
public class deletePassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private PassengerService ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletePassenger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("id");
		ps.deletePassenger(Integer.parseInt(pid));
		response.sendRedirect("listpassengers");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
