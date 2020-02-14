package com.airline.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Airplane;
import com.airline.models.Flight;
import com.airline.models.FlightStatus;
import com.airline.models.Pilot;
import com.airlines.beans.AirplaneService;
import com.airlines.beans.FlightService;
import com.airlines.beans.PiloteService;

/**
 * Servlet implementation class addFlight
 */
@WebServlet("/addFlight")
public class addFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private AirplaneService aps;
	
	@EJB
	private FlightService fls;
	
	@EJB
	private PiloteService ps;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("planes", aps.getOperationalPlanes());
		request.setAttribute("pilots", ps.getAllPilots());
		
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_flight.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String origin = request.getParameter("flightOrigin");
		String destination = request.getParameter("flightDestination");
		String depatureTime = request.getParameter("depatureTime");
		String arrivalTime = request.getParameter("arrivalTime");
		String duration = request.getParameter("duration");
		String reference = request.getParameter("reference");
		String status = request.getParameter("status");
		String planeid = request.getParameter("plane");
		String[] paramPilots = request.getParameterValues("pilots");
		
		//depture time treatemnt
		String dt_array[] = depatureTime.split("\\/");
		String dt_date = dt_array[0];
		String dt_time = dt_array[1];
		
		String dt_dateArray[] = dt_date.split("-");
		String dt_timeArray[] = dt_time.split(":");
		String dtday = dt_dateArray[0];
		String dtmonth = dt_dateArray[1];
		String dtyear = dt_dateArray[2];
		
		String dthour =  dt_timeArray[0];
		String dtminute =  dt_timeArray[0];
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, Integer.parseInt(dtyear));
		cal.set(Calendar.MONTH, Integer.parseInt(dtmonth)-1);
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dtday));
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(dthour));
		cal.set(Calendar.MINUTE, Integer.parseInt(dtminute));
		
		Date final_dt = cal.getTime();
		
		//arrival time treatemnt
		String at_array[] = arrivalTime.split("\\/");
		String at_date = at_array[0];
		String at_time = at_array[1];
		
		String at_dateArray[] = at_date.split("-");
		String at_timeArray[] = at_time.split(":");
		String atday = at_dateArray[0];
		String atmonth = at_dateArray[1];
		String atyear = at_dateArray[2];
		
		String athour =  at_timeArray[0];
		String atminute =  at_timeArray[0];
		
		Calendar cal2 = Calendar.getInstance();
		
		cal2.set(Calendar.YEAR, Integer.parseInt(atyear));
		cal2.set(Calendar.MONTH, Integer.parseInt(atmonth)-1);
		cal2.set(Calendar.DAY_OF_MONTH, Integer.parseInt(atday));
		cal2.set(Calendar.HOUR_OF_DAY, Integer.parseInt(athour));
		cal2.set(Calendar.MINUTE, Integer.parseInt(atminute));
		
		Date final_at = cal2.getTime();
		
		Flight fl = new Flight();
		fl.setArrivalTime(final_at);
		fl.setDepatureTime(final_dt);
		fl.setDuration(duration);
		fl.setFlightDestination(destination);
		fl.setFlightOrigin(origin);
		fl.setReference(reference);
		fl.setStatus(FlightStatus.valueOf(status));
		
		List<Pilot> pilots = new ArrayList<Pilot>();
		
		if(paramPilots == null) {
			fl.setPilots(null);
		}else {
			for (String pid : paramPilots) {
				Pilot pilot = ps.getPilotById(Integer.parseInt(pid));
				pilots.add(pilot);
			}

			fl.setPilots(pilots);
		}
		
		Airplane plane = aps.getPlaneById(Integer.parseInt(planeid));
		
		List<Flight> flist = plane.getFlights();
		flist.add(fl);
		
		fl.setAirplane(plane);
		
		fls.saveFlight(fl);
		
		response.sendRedirect("listFlights");
	}

}
