package com.dlt.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Systems are created and updated by the user. A system cannot be deleted if it
 * has any data in its any level of the structure.<br>
 * • The ops hours is automatically updated everyday as: (Today Date–Commission
 * Date) X 24 X Duty Cycle
 *
 * @author Shivam
 *
 */
@Entity
public class EOSystem extends EOObject {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long systemId;
	private String systemName;

	private float dutyCycle;
	private Date opsStateDate;
	private float startOpsHour;
	private float opsHour;
	private String sytemStatus;//Commissioned,Operational,Maintenance
	private String version; // System version.

	@ManyToOne
	@JoinColumn(name = "stationID", nullable = false)
	private EOStation station;

	public Long getSystemId() {
		return this.systemId;
	}

	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}

	public String getSystemName() {
		return this.systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public float getDutyCycle() {
		return this.dutyCycle;
	}

	public void setDutyCycle(float dutyCycle) {
		this.dutyCycle = dutyCycle;
	}

	public Date getOpsStateDate() {
		return this.opsStateDate;
	}

	public void setOpsStateDate(Date opsStateDate) {
		this.opsStateDate = opsStateDate;
	}

	public float getStartOpsHour() {
		return this.startOpsHour;
	}

	public void setStartOpsHour(float startOpsHour) {
		this.startOpsHour = startOpsHour;
	}

	public float getOpsHour() {
		return this.opsHour;
	}

	public void setOpsHour(float opsHour) {
		this.opsHour = opsHour;
	}

	public String getSytemStatus() {
		return this.sytemStatus;
	}

	public void setSytemStatus(String sytemStatus) {
		this.sytemStatus = sytemStatus;
	}

	public EOStation getStation() {
		return this.station;
	}

	public void setStation(EOStation station) {
		this.station = station;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
