package com.airline.webservices.rest;

import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.airline.models.Gender;
import com.airline.models.Passenger;
import com.airlines.beans.PassengerService;

@Path("/passengers")
public class PassengerWebService {
	

	@PersistenceContext(unitName = "airline")
	private EntityManager em;
	
	@EJB
	PassengerService ps;
	
	@Context
	UriInfo puriInfo;
	
	public PassengerWebService() {
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Passenger> getPassengers(){
		List<Passenger> plist = ps.getAllPassengers();
		
		return plist;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{pass_id}")
	public Passenger getPassenger(@PathParam("pass_id") Integer passId) {
		Passenger p = ps.getPassengerById(passId);
		if(p == null) {
			throw new NotFoundException("No passenger found with those criteria !");
		}
		return p;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPassenger(Passenger p) {
		p = ps.addPassenger(p);
		
		UriBuilder pUriBuilder = puriInfo.getAbsolutePathBuilder();
		
		URI pUri = pUriBuilder.path(String.valueOf(p.getId())).build();
		
		return Response.created(pUri).build();
	}
	
	@PUT
	@Path("/edit/{pId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePassenger(@PathParam("pId") Integer pId, Passenger pu) {
		Passenger pass = ps.getPassengerById(pId);
		
		if(pass == null) {
			throw new NotFoundException("No matching passenger found !!");
		}
		
		pu.setId(pass.getId());

		ps.update(pu);
		
		return Response.ok(pu).build();
	}
	
	@DELETE
	@Path("/delete/{pId}")
	public Response deletePassenger(@PathParam("pId") Integer pId) {
		Passenger pass = ps.getPassengerById(pId);
		if(pass == null) {
			throw new NotFoundException("No Matching passenger found !");
		}
		ps.deletePassenger(pId);
		
		return Response.noContent().build();
	}
}
