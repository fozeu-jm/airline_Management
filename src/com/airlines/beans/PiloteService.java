package com.airlines.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.config.QueryHints;

import com.airline.models.Pilot;

/**
 * Session Bean implementation class PiloteService
 */
@Stateless
@LocalBean
public class PiloteService {
	
	@PersistenceContext(unitName = "airline")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public PiloteService() {
        // TODO Auto-generated constructor stub
    }
    
    public void storePilote(Pilot pi) {
    	em.persist(pi);
    }
    
    public List<Pilot> getAllPilots(){
    	TypedQuery<Pilot> query = em.createNamedQuery("findAllPilots",Pilot.class);
    	return query.getResultList();
    }
    
    public void deletePilot(String id) {
    	Pilot pi = getPilotById(Integer.parseInt(id));
    	em.remove(pi);
    }
    
    public Pilot getPilotById(Integer pid) {
    	TypedQuery<Pilot> query = em.createNamedQuery("findPilotById",Pilot.class).setHint(QueryHints.REFRESH, true);
    	query.setParameter("pid", pid);
    	Pilot pi = null;
    	try {
			pi = query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
    	return pi;
    }
    
    public void editPilote(Pilot pi) {
    	em.merge(pi);
    }

}
