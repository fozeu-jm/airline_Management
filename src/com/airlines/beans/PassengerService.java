package com.airlines.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.config.QueryHints;

import com.airline.models.Passenger;

/**
 * Session Bean implementation class PassengerService
 */
@Stateless
@LocalBean
public class PassengerService {
	
	@PersistenceContext(unitName = "airline")
	private EntityManager em;
	
	
    /**
     * Default constructor. 
     */
    public PassengerService() {
        // TODO Auto-generated constructor stub
    }
    
    public Passenger addPassenger(Passenger passenger) {
    	em.persist(passenger);
    	return passenger;
    }
    
    public void update(Passenger passenger) {
    	em.merge(passenger);
    }
    
    public void deletePassenger(Integer pid) {
    	em.remove(getPassengerById(pid));
    }
    
    public Passenger getPassengerById(Integer id) {
    	TypedQuery<Passenger> query = em.createNamedQuery("findPassengerById", Passenger.class).setHint(QueryHints.REFRESH, true);
    	query.setParameter("id", id);
    	Passenger p = null;
    	try {
			p = query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
    	return p;
    }
    
    public List<Passenger> getAllPassengers(){
    	TypedQuery<Passenger> query = em.createNamedQuery("findAllPassengers",Passenger.class);
    	
    	return query.getResultList();
    }

}
