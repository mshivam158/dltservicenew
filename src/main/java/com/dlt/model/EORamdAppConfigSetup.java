package com.dlt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EORamdAppConfigSetup extends EOObject {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long primaryKey;
	@Column(name = "MaxClientAccount")
	private Integer maxClientAccount = 100;//Total no. of accounts in the active database. When exceeded, the oldest in the inactive state state shall be archived
	@Column(name = "MaxProject")
	private Integer maxProject = 10;//Upper limit on no. of project per account. Application shall check and reject the creation of new project if it is above the upper limit
	@Column(name = "MaxAssetMasterList")
	private Integer maxAssetMasterList = 10;//Upper limit on no. of asset masters per project. Application shall check and reject the  creation of new asset master if it is above the upper limit
	@Column(name = "MaxAssetMaster")
	private Integer maxAssetMaster = 10;//Upper limit on no. of asset masters per project. Application shall check and reject the  creation of new asset master if it is above the upper limit
	@Column(name = "MaxAsset")
	private Integer maxAsset = 1000;//Upper limit on no. of asset per asset master. Application shall check and reject the addition of new asset if it is above the upper limit
	@Column(name = "MaxStation")
	private Integer maxStation = 100;//Upper limit on no. of stations per project. Application shall check and reject the addition of new station if it is above the upper limit
	@Column(name = "MaxSystem")
	private Integer maxSystem = 10;//Upper limit on no. of systems per project. Application shall check and reject the addition of new system if it is above the upper limit
	@Column(name = "MaxSystemAsset")
	private Integer maxSystemAsset = 1000; //Upper limit on no. of assets per system. Application shall check and reject the addition of new asset if it is above the upper limit
	@Column(name = "MaxRBD")
	private Integer maxRbd = 10; //Upper limit on no. of RBD versions per system. Application shall check and reject the creation of new RBD if it is above the upper limit
	@Column(name = "MaxRBDElement")
	private Integer maxRbdElement = 1000;//Upper limit on no. of RBD elements per RBD. Application shall check and reject the addition of new RBD Element if it is above the upper limit
	@Column(name = "MaxRamBaseline")
	private Integer maxRamBaseline = 1; //Upper limit on no. of RAM Baselines per system. Application shall check and reject the addition of new basline if it is above the upper limit
	@Column(name = "MaxHazardBaseline")
	private Integer maxHazardBaseline = 1; //Upper limit on no. of Hazard Baselines per system. Application shall check and reject the addition of new basline if it is above the upper limit
	@Column(name = "MaxFailureReport")
	private Integer maxFailureReport = 1000; //Upper limit on no. of Failure Reports active in the database. Application shall archive the oldest and closed reports, if the limit is exceeded
	@Column(name = "MaxEquipmentFailureRecord")
	private Integer maxEquipmentFailureRecord = 1000; //Upper limit on no. of Equipment Failure Records active in the database. Application shall archive the oldest records, if the limit is exceeded
	@Column(name = "MaxRamRecord")
	private Integer maxRamRecord = 1000; //Upper limit on no. of RAM Records active in the database. Application shall archive the oldest records, if the limit is exceeded
	@Column(name = "MaxHazardRecord")
	private Integer maxHazardRecord = 1000; //Upper limit on no. of Hazard Records active in the database. Application shall archive the oldest records, if the limit is exceeded

	public Long getPrimaryKey() {
		return this.primaryKey;
	}

	public void setPrimaryKey(Long primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Integer getMaxClientAccount() {
		return this.maxClientAccount;
	}

	public void setMaxClientAccount(Integer maxClientAccount) {
		this.maxClientAccount = maxClientAccount;
	}

	public Integer getMaxProject() {
		return this.maxProject;
	}

	public void setMaxProject(Integer maxProject) {
		this.maxProject = maxProject;
	}

	public Integer getMaxAssetMasterList() {
		return this.maxAssetMasterList;
	}

	public void setMaxAssetMasterList(Integer maxAssetMasterList) {
		this.maxAssetMasterList = maxAssetMasterList;
	}

	public Integer getMaxAssetMaster() {
		return this.maxAssetMaster;
	}

	public void setMaxAssetMaster(Integer maxAssetMaster) {
		this.maxAssetMaster = maxAssetMaster;
	}

	public Integer getMaxAsset() {
		return this.maxAsset;
	}

	public void setMaxAsset(Integer maxAsset) {
		this.maxAsset = maxAsset;
	}

	public Integer getMaxStation() {
		return this.maxStation;
	}

	public void setMaxStation(Integer maxStation) {
		this.maxStation = maxStation;
	}

	public Integer getMaxSystem() {
		return this.maxSystem;
	}

	public void setMaxSystem(Integer maxSystem) {
		this.maxSystem = maxSystem;
	}

	public Integer getMaxSystemAsset() {
		return this.maxSystemAsset;
	}

	public void setMaxSystemAsset(Integer maxSystemAsset) {
		this.maxSystemAsset = maxSystemAsset;
	}

	public Integer getMaxRbd() {
		return this.maxRbd;
	}

	public void setMaxRbd(Integer maxRbd) {
		this.maxRbd = maxRbd;
	}

	public Integer getMaxRbdElement() {
		return this.maxRbdElement;
	}

	public void setMaxRbdElement(Integer maxRbdElement) {
		this.maxRbdElement = maxRbdElement;
	}

	public Integer getMaxRamBaseline() {
		return this.maxRamBaseline;
	}

	public void setMaxRamBaseline(Integer maxRamBaseline) {
		this.maxRamBaseline = maxRamBaseline;
	}

	public Integer getMaxHazardBaseline() {
		return this.maxHazardBaseline;
	}

	public void setMaxHazardBaseline(Integer maxHazardBaseline) {
		this.maxHazardBaseline = maxHazardBaseline;
	}

	public Integer getMaxFailureReport() {
		return this.maxFailureReport;
	}

	public void setMaxFailureReport(Integer maxFailureReport) {
		this.maxFailureReport = maxFailureReport;
	}

	public Integer getMaxEquipmentFailureRecord() {
		return this.maxEquipmentFailureRecord;
	}

	public void setMaxEquipmentFailureRecord(Integer maxEquipmentFailureRecord) {
		this.maxEquipmentFailureRecord = maxEquipmentFailureRecord;
	}

	public Integer getMaxRamRecord() {
		return this.maxRamRecord;
	}

	public void setMaxRamRecord(Integer maxRamRecord) {
		this.maxRamRecord = maxRamRecord;
	}

	public Integer getMaxHazardRecord() {
		return this.maxHazardRecord;
	}

	public void setMaxHazardRecord(Integer maxHazardRecord) {
		this.maxHazardRecord = maxHazardRecord;
	}

}
