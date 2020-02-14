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
 * Servlet implementation class editFlight
 */
@WebServlet("/editFlight")
public class editFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private FlightService fs;
	@EJB
	private AirplaneService aps;
	@EJB
	private PiloteService ps;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editFlight() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null) {
			response.sendRedirect("listFlights");
		} else {
			Flight fl = fs.getFlightById(Integer.parseInt(id));
			List<Airplane> plist = aps.getAllPlanes();
			List<String> slist = new ArrayList<String>();
			slist.add(FlightStatus.ABORTED.name());
			slist.add(FlightStatus.DELAYED.name());
			slist.add(FlightStatus.ON_SCHEDULE.name());

			List<Pilot> allPilots = ps.getAllPilots();

			List<Pilot> selectedPilots = fl.getPilots();

			request.setAttribute("planes", plist);
			request.setAttribute("flight", fl);
			request.setAttribute("slist", slist);

			allPilots.removeAll(selectedPilots);

			request.setAttribute("allPilots", allPilots);

			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/edit_flight.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fid = request.getParameter("fid");
		String origin = request.getParameter("flightOrigin");
		String destination = request.getParameter("flightDestination");
		String depatureTime = request.getParameter("depatureTime");
		String arrivalTime = request.getParameter("arrivalTime");
		String duration = request.getParameter("duration");
		String status = request.getParameter("status");
		String reference = request.getParameter("reference");
		String planeid = request.getParameter("plane");
		String[] paramPilots = request.getParameterValues("pilots");

		// depture time treatemnt
		String dt_array[] = depatureTime.split("\\/");
		String dt_date = dt_array[0];
		String dt_time = dt_array[1];

		String dt_dateArray[] = dt_date.split("-");
		String dt_timeArray[] = dt_time.split(":");
		String dtday = dt_dateArray[0];
		String dtmonth = dt_dateArray[1];
		String dtyear = dt_dateArray[2];

		String dthour = dt_timeArray[0];
		String dtminute = dt_timeArray[0];

		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, Integer.parseInt(dtyear));
		cal.set(Calendar.MONTH, Integer.parseInt(dtmonth) - 1);
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dtday));
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(dthour));
		cal.set(Calendar.MINUTE, Integer.parseInt(dtminute));

		Date final_dt = cal.getTime();

		// arrival time treatemnt
		String at_array[] = arrivalTime.split("\\/");
		String at_date = at_array[0];
		String at_time = at_array[1];

		String at_dateArray[] = at_date.split("-");
		String at_timeArray[] = at_time.split(":");
		String atday = at_dateArray[0];
		String atmonth = at_dateArray[1];
		String atyear = at_dateArray[2];

		String athour = at_timeArray[0];
		String atminute = at_timeArray[0];

		Calendar cal2 = Calendar.getInstance();

		cal2.set(Calendar.YEAR, Integer.parseInt(atyear));
		cal2.set(Calendar.MONTH, Integer.parseInt(atmonth) - 1);
		cal2.set(Calendar.DAY_OF_MONTH, Integer.parseInt(atday));
		cal2.set(Calendar.HOUR_OF_DAY, Integer.parseInt(athour));
		cal2.set(Calendar.MINUTE, Integer.parseInt(atminute));

		Date final_at = cal2.getTime();

		Flight fl = fs.getFlightById(Integer.parseInt(fid));
		fl.setArrivalTime(final_at);
		fl.setDepatureTime(final_dt);
		fl.setDuration(duration);
		fl.setFlightDestination(destination);
		fl.setReference(reference);
		fl.setFlightOrigin(origin);
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
		
		fl.setAirplane(plane);
		
		List<Flight> flist = plane.getFlights();
		flist.add(fl);

		fs.update(fl);

		response.sendRedirect("listFlights");
	}

}
