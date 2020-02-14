package com.airlines.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.config.QueryHints;

import com.airline.models.Airplane;
import com.airline.models.Flight;
import com.airline.models.PlaneStatus;

/**
 * Session Bean implementation class AirplaneService
 */
@Stateless
@LocalBean
public class AirplaneService {
	
	@PersistenceContext(unitName = "airline")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public AirplaneService() {
        
    }
    
    public void savePlane(Airplane ap) {
    	em.persist(ap);
    	
    }
    
    public List<Airplane> getAllPlanes(){
    	TypedQuery<Airplane> pquery = em.createNamedQuery("findAllPlanes",Airplane.class);
    	List<Airplane> ap = pquery.getResultList();
    	
		return ap;
    }
    
    public Airplane getPlaneById(Integer id) {
    	TypedQuery<Airplane> pquery = em.createNamedQuery("findPlaneById",Airplane.class).setHint(QueryHints.REFRESH, true);
    	pquery.setParameter("id", id);
    	Airplane a = null;
    	try {
			a = pquery.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
    	return a;
    }
    
    public void deletePlane(Integer id ) {
    	Airplane ap = getPlaneById(id);
    	//em.refresh(ap);
    	List<Flight> flights = ap.getFlights();
    	System.out.println(ap.toString());
    	for(Flight fl : flights) {
    		System.out.println("There was a flight on this plane");
    		fl.setAirplane(null);
    		em.merge(fl);
    	}
    	
    	//ap.setFlights(null);
    	
    	//em.remove(ap);
    }
    
    public void update(Airplane ap) {
    	em.merge(ap);
    }
    
    public List<Airplane> getOperationalPlanes(){
    	TypedQuery<Airplane> pquery = em.createNamedQuery("findOperationalPlanes",Airplane.class);
    	pquery.setParameter("stat", PlaneStatus.Operational);
    	List<Airplane> ap = pquery.getResultList();
    	
		return ap;
    }

}
