package com.airline.controllers;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.airlines.beans.PiloteService;

/**
 * Servlet implementation class deletePilote
 */
@WebServlet("/deletePilot")
public class deletePilote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private PiloteService ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletePilote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null) {
			response.sendRedirect("pilotList");
		}else {
			ps.deletePilot(id);
			response.sendRedirect("pilotList");
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
