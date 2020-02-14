package com.airlines.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.config.QueryHints;

import com.airline.models.Ticket;

/**
 * Session Bean implementation class TicketService
 */
@Stateless
@LocalBean
public class TicketService {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName = "airline")
	private EntityManager em;
	
    public TicketService() {
        
    }
    
    public Ticket getTicketById(Integer id) {
    	TypedQuery<Ticket> query = em.createNamedQuery("findTicketById", Ticket.class).setHint(QueryHints.REFRESH, true);
    	query.setParameter("tid", id);
    	return query.getSingleResult();
    }
    
    public void deleteTicket(Integer id) {
    	em.remove(getTicketById(id));
    }
    
    public void register(Ticket t) {
    	em.persist(t);
    }

}
