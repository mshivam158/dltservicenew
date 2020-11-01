package com.dlt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Stations are created and updated by the user. A station cannot be deleted if
 * it has any data in its system and its lower levels of the structure.
 *
 * @author Shivam
 *
 */
@Entity
public class EOStation extends EOObject {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long stationId;
	private String stationName;

	private Long systems;

	@ManyToOne
	@JoinColumn(name = "projectID", nullable = false)
	private EOProject project;

	public Long getStationId() {
		return this.stationId;
	}

	public void setStationId(Long stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return this.stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Long getSystems() {
		return this.systems;
	}

	public void setSystems(Long systems) {
		this.systems = systems;
	}

	public EOProject getProject() {
		return this.project;
	}

	public void setProject(EOProject project) {
		this.project = project;
	}

}
