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
public class EOAsset extends EOObject {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "AssetID")
	private Long assetId;
	@Column(name = "SerialBatchNo")
	private String traceability;
	@Column(name = "OperationLife")
	private Float opsLife;
	@Column(name = "OpsHour")
	private Float opshour;
	@Column(name = "ResidualLife")
	private Float residualLife;
	@Column(name = "MTBFBaseline")
	private Float mtbfBaseline;
	@Column(name = "MTBFCurrent")
	private Float mtbfcurrent;
	@Column(name = "MTTRBaseline")
	private Float mttrBaseline;
	@Column(name = "mttrCurrent")
	private Float mttrCurrent;
	@Column(name = "CriticalItem")
	private String criticalItem;
	@Column(name = "AssetStatus")
	private String assetStatus;
	/*
	 * @Column(name="SystemID") private System systemID;
	 */

}
