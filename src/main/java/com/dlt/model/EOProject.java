package com.dlt.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.dlt.enumconstant.DLPReporting;
import com.dlt.enumconstant.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "findByClientAccount", query = "select e from EOProject e where e.clientId.clientId =:clientPK")
public class EOProject extends EOObject {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ProjectId")
	private Long projectId;
	@Column(name = "ProjectName", nullable = false)
	private String projectName;
	@Column(name = "StartDate", nullable = false)
	private Date startDate;
	@Column(name = "FinishDate", nullable = false)
	private Date finishDate;
	@Column(name = "DLPStartDate", nullable = false)
	private Date dlpStartDate;
	@Column(name = "DLPFinishDate", nullable = false)
	private Date dlpFinishDate;
	@Column(name = "DLPReporting")
	@Enumerated(EnumType.STRING)
	private DLPReporting dlpReporting = DLPReporting.Quarteryly;
	@Column(name = "Status")
	@Enumerated(EnumType.STRING)
	private Status status = Status.Created;
	@Column(name = "Stations", nullable = false)
	private Long stations; ///noOfStation, in which this project assign.

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

	public Date getDlpStartDate() {
		return this.dlpStartDate;
	}

	public void setDlpStartDate(Date dlpStartDate) {
		this.dlpStartDate = dlpStartDate;
	}

	public Date getDlpFinishDate() {
		return this.dlpFinishDate;
	}

	public void setDlpFinishDate(Date dlpFinishDate) {
		this.dlpFinishDate = dlpFinishDate;
	}

	public DLPReporting getDlpReporting() {
		return this.dlpReporting;
	}

	public void setDlpReporting(DLPReporting dlpReporting) {
		this.dlpReporting = dlpReporting;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getStations() {
		return this.stations;
	}

	public void setStations(Long stations) {
		this.stations = stations;
	}

	public EOClientAccount getClientId() {
		return this.clientId;
	}

	public void setClientId(EOClientAccount clientId) {
		this.clientId = clientId;
	}

	@ManyToOne
	@JoinColumn(name = "ClientID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EOClientAccount clientId;

	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
