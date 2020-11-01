package com.dlt.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class EOProjectInfo extends EOObject {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long primaryKey;

	private Date startDate;
	private Date finishDate;
	private Date dlpStart;
	private Date dlpFinish;
	private Long stations;//noOfStation, in which this project assign.
	private String status;//Active, Closed

	@OneToOne
	@JoinColumn(name = "projectID", nullable = false)
	private EOProject project; //index should be applied on this column.

	public Long getPrimaryKey() {
		return this.primaryKey;
	}

	public void setPrimaryKey(Long primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return this.finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public Date getDlpStart() {
		return this.dlpStart;
	}

	public void setDlpStart(Date dlpStart) {
		this.dlpStart = dlpStart;
	}

	public Date getDlpFinish() {
		return this.dlpFinish;
	}

	public void setDlpFinish(Date dlpFinish) {
		this.dlpFinish = dlpFinish;
	}

	public Long getStations() {
		return this.stations;
	}

	public void setStations(Long stations) {
		this.stations = stations;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public EOProject getProject() {
		return this.project;
	}

	public void setProject(EOProject project) {
		this.project = project;
	}

}
