package com.airline.webservices.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.airline.models.Flight;
import com.airlines.beans.FlightService;

@Path("/flights")
public class FlightsWebService {

	@PersistenceContext(unitName = "airline")
	EntityManager em;

	@EJB
	FlightService fs;

	@Context
	UriInfo furiInfo;

	public FlightsWebService() {

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> getFlights() {
		List<Flight> flist = fs.getAllFlights();
		return flist;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{fl_id}")
	public Flight getFlight(@PathParam("fl_id") Integer flId) {
		Flight fl = fs.getFlightById(flId);
		if (fl == null) {
			throw new NotFoundException("No flight found with those criteria !");
		}
		return fl;
	}

}
