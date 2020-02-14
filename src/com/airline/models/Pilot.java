package com.airline.models;

import java.io.Serializable;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pilot
 *
 */
@NamedQuery(name = "findPilotById", query = "SELECT pi FROM Pilot pi WHERE pi.id = :pid")
@NamedQuery(name = "findAllPilots", query = "SELECT pi FROM Pilot pi")
@Entity
public class Pilot implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public Pilot() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String firstName;

	private String LastName;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private Long pilotLicence;

	private String email;

	private String phoneNo;

	@ManyToMany(mappedBy = "pilots")
	@JsonbTransient
	private List<Flight> flights;

	@Enumerated(EnumType.STRING)
	private PilotRank rank;

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
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public Long getPilotLicence() {
		return pilotLicence;
	}

	public void setPilotLicence(Long pilotLicence) {
		this.pilotLicence = pilotLicence;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public PilotRank getRank() {
		return rank;
	}

	public void setRank(PilotRank rank) {
		this.rank = rank;
	}

	@Override
	public boolean equals(Object obj) {
		Pilot pi = (Pilot) obj;
		if (this.id == pi.id) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Pilot [id=" + id + ", firstName=" + firstName + ", LastName=" + LastName + ", gender=" + gender
				+ ", pilotLicence=" + pilotLicence + ", email=" + email + ", phoneNo=" + phoneNo + ", rank=" + rank
				+ "]";
	}

}
