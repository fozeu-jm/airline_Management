package com.airline.models;

import java.io.Serializable;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Airplane
 *
 */
@NamedQuery(name = "findPlaneById", query = "SELECT p FROM Airplane p WHERE p.id = :id")
@NamedQuery(name = "findAllPlanes", query = "SELECT p FROM Airplane p")
@NamedQuery(name = "findOperationalPlanes", query = "SELECT p FROM Airplane p WHERE p.status = :stat")
@Entity
public class Airplane implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public Airplane() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String planeMake;

	private String modelName;

	private Integer seatingCapacity;
	
	@Enumerated(EnumType.STRING)
	private PlaneStatus status;

	@OneToMany(mappedBy = "airplane")
	@JsonbTransient
	private List<Flight> flights;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaneMake() {
		return planeMake;
	}

	public void setPlaneMake(String planeMake) {
		this.planeMake = planeMake;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Integer getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(Integer seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public PlaneStatus getStatus() {
		return status;
	}

	public void setStatus(PlaneStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Airplane [id=" + id + ", planeMake=" + planeMake + ", modelName=" + modelName + ", seatingCapacity="
				+ seatingCapacity + ", status=" + status + ", flights=" + flights + "]";
	}

	

}
