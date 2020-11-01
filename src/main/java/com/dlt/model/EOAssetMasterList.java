package com.dlt.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = { "AssetMasterName", "AssetMasterVersion" })
})
@NamedQuery(name = "findByProjectPk", query = "select e from EOAssetMasterList e where e.projectID.projectId =:projectPK")
@NamedQuery(name = "findByProjectPkCount", query = "select count(e) from EOAssetMasterList e where e.projectID.projectId =:projectPK")
public class EOAssetMasterList extends EOObject {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AssetMasterListId")
	private Long assetMasterListId;
	@Column(name = "AssetMasterName", nullable = false)
	private String assetMasterName;
	@Column(name = "AssetMasterVersion", nullable = false)
	private String assetMasterVersion; //   3 digit   x-yy
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "DateOfCreation")
	private LocalDateTime dateOfCreation;
	@Column(name = "AssetMasterNameAndVersion")
	private String assetMasterNameAndVersion;

	@ManyToOne
	@JoinColumn(name = "ProjectID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EOProject projectID;

	public Long getAssetMasterListId() {
		return this.assetMasterListId;
	}

	public void setAssetMasterListId(Long assetMasterListId) {
		this.assetMasterListId = assetMasterListId;
	}

	public String getAssetMasterName() {
		return this.assetMasterName;
	}

	public void setAssetMasterName(String assetMasterName) {
		this.assetMasterName = assetMasterName;
	}

	public String getAssetMasterVersion() {
		return this.assetMasterVersion;
	}

	public void setAssetMasterVersion(String assetMasterVersion) {
		this.assetMasterVersion = assetMasterVersion;
	}

	public LocalDateTime getDateOfCreation() {
		return this.dateOfCreation;
	}

	public void setDateOfCreation(LocalDateTime dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public String getAssetMasterNameAndVersion() {
		return this.assetMasterNameAndVersion;
	}

	public void setAssetMasterNameAndVersion(String assetMasterNameAndVersion) {
		this.assetMasterNameAndVersion = assetMasterNameAndVersion;
	}

	public EOProject getProjectID() {
		return this.projectID;
	}

	public void setProjectID(EOProject projectID) {
		this.projectID = projectID;
	}

}
