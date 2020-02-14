package com.airline.models;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Ticket
 *
 */
@NamedQuery(name = "findTicketById", query = "SELECT t FROM Ticket t WHERE t.id = :tid")
@Entity
@XmlRootElement
public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Double price;

	@ManyToOne
	@JoinColumn(name = "passenger_fk")
	private Passenger passenger;

	@ManyToOne
	@JoinColumn(name = "flight_fk")
	@JsonbTransient
	private Flight flight;

	@Enumerated(EnumType.STRING)
	private FlightClass flightClass;

	public Ticket() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public FlightClass getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(FlightClass flightClass) {
		this.flightClass = flightClass;
	}

}
