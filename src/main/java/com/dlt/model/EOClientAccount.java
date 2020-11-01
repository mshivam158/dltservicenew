package com.dlt.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dlt.enumconstant.Status;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * • Above data is entered by the system administrator through system admin
 * interface.<br>
 * • When the license expiry date is reached, DLT automatically changes the
 * client status to inactive.<br>
 * • On login, the client’s active status and user credential are validated.
 * Access is granted only to the licensed application(s). This feature shall be
 * implemented with <b>keycloak</b> of the framework.
 *
 * @author Shivam
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel
public class EOClientAccount extends EOObject {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long clientId;
	@Column(name = "ClientName", nullable = false)
	private String clientName;
	@Column(name = "Applications", nullable = false)
	@ApiModelProperty(required = true)
	private String[] applications;
	@Column(name = "LicenseStart", nullable = false)
	@ApiModelProperty(required = true)
	private Date licenseStart;
	@Column(name = "LicenseExpiry", nullable = false)
	@ApiModelProperty(required = true)
	private Date licenseExpiry;
	@Column(name = "UserID", nullable = false)
	@ApiModelProperty(required = true)
	private String userId;//email id
	@Column(name = "Password", nullable = false)
	@ApiModelProperty(required = true)
	private String password;
	@Column(name = "ClientStatus")
	@Enumerated(EnumType.STRING)
	private Status clientStatus = Status.Created;//Active,Inactive

	public void setLicenseExpiry(Date licenseExpiry) {
		this.licenseExpiry = licenseExpiry;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Status getClientStatus() {
		return this.clientStatus;
	}

	public void setClientStatus(Status clientStatus) {
		this.clientStatus = clientStatus;
	}

	public Long getClientId() {
		return this.clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	@ApiModelProperty(required = true)
	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String[] getApplications() {
		return this.applications;
	}

	public void setApplications(String[] applications) {
		this.applications = applications;
	}

	public Date getLicenseStart() {
		return this.licenseStart;
	}

	public void setLicenseStart(Date licenseStart) {
		this.licenseStart = licenseStart;
	}

	public Date getLicenseExpiry() {
		return this.licenseExpiry;
	}

}
