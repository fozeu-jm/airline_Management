package com.airline.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Flight
 *
 */
@NamedQuery(name = "findAllFlights", query = "SELECT f FROM Flight f")
@NamedQuery(name = "findFlightById", query = "SELECT f FROM Flight f WHERE f.id = :id")
@Entity
public class Flight implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String reference;

	private String flightDestination;

	private String flightOrigin;

	private Double price;

	@Temporal(TemporalType.TIMESTAMP)
	private Date depatureTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date arrivalTime;

	private String duration;

	@Enumerated(EnumType.STRING)
	private FlightStatus status;

	@OneToMany(mappedBy = "flight")
	private List<Ticket> tickets;

	@ManyToOne
	@JoinColumn(name = "airplane_fk")
	private Airplane airplane;

	@ManyToMany
	@JoinTable(name = "pilot_flight", joinColumns = @JoinColumn(name = "flight_id"), inverseJoinColumns = @JoinColumn(name = "pilot_id"))
	private List<Pilot> pilots;

	public Flight() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFlightDestination() {
		return flightDestination;
	}

	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	}

	public String getFlightOrigin() {
		return flightOrigin;
	}

	public void setFlightOrigin(String flightOrigin) {
		this.flightOrigin = flightOrigin;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getDepatureTime() {
		return depatureTime;
	}

	public void setDepatureTime(Date depatureTime) {
		this.depatureTime = depatureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public FlightStatus getStatus() {
		return status;
	}

	public void setStatus(FlightStatus status) {
		this.status = status;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public List<Pilot> getPilots() {
		return pilots;
	}

	public void setPilots(List<Pilot> pilots) {
		this.pilots = pilots;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", reference=" + reference + ", flightDestination=" + flightDestination
				+ ", flightOrigin=" + flightOrigin + ", price=" + price + ", depatureTime=" + depatureTime
				+ ", arrivalTime=" + arrivalTime + ", duration=" + duration + ", status=" + status + ", airplane="
				+ airplane + "]";
	}

}
