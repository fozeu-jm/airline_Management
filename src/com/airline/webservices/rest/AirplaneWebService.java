package com.airline.webservices.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.airline.models.Airplane;
import com.airlines.beans.AirplaneService;

@Path("/airplanes")
public class AirplaneWebService {

	@PersistenceContext(unitName = "airline")
	private EntityManager em;
	
	@EJB
	AirplaneService aps;
	
	@Context
	UriInfo apuriInfo;
	
	public AirplaneWebService() {
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airplane> getAirplanes(){
		List<Airplane> aplist = aps.getAllPlanes();
		
		return aplist;
	}
}
