package com.airlines.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.config.QueryHints;
import com.airline.models.Flight;

/**
 * Session Bean implementation class FlightService
 */
@Stateless
@LocalBean
public class FlightService {
	@PersistenceContext(unitName = "airline")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public FlightService() {
        // TODO Auto-generated constructor stub
    }
    
    public Flight getFlightById(Integer id) {
    	TypedQuery<Flight> query = em.createNamedQuery("findFlightById", Flight.class).setHint(QueryHints.REFRESH, true);
    	query.setParameter("id", id);
    	Flight fl = null;
    	try {
			fl = query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
    	
    	return fl;
    }
    
    public List<Flight> getAllFlights (){
    	TypedQuery<Flight> query = em.createNamedQuery("findAllFlights", Flight.class);
    	return query.getResultList();
    }
    
    public void update(Flight fl) {
    	em.merge(fl);
    }
    
    public void deleteFlight(Integer fid) {
    	em.remove(getFlightById(fid));
    }
    
    public void saveFlight(Flight fl) {
    	
    	em.persist(fl);
    	
    }

}
