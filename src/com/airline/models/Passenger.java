package com.airline.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Passenger
 *
 */

@NamedQuery(name = "findPassengerById", query = "SELECT a FROM Passenger a WHERE a.id = :id")
@NamedQuery(name = "findAllPassengers", query = "SELECT a FROM Passenger a")
@Entity
@XmlRootElement
public class Passenger implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String firstName;

	private String lastName;

	private Integer passNo;

	private String email;

	@OneToMany(mappedBy = "passenger")
	@JsonbTransient
	@XmlTransient
	private List<Ticket> tickets;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	private FlightClass flightClass;

	// public
	public Passenger() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getPassNo() {
		return passNo;
	}

	public void setPassNo(Integer passNo) {
		this.passNo = passNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public FlightClass getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(FlightClass flightClass) {
		this.flightClass = flightClass;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", passNo=" + passNo
				+ ", email=" + email + ", dob=" + dob + ", gender=" + gender + "]";
	}

}
