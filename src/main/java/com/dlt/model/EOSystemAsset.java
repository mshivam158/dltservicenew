package com.dlt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.dlt.enumconstant.AssetStatus;
import com.dlt.enumconstant.CriticalItem;
import com.dlt.enumconstant.Repairable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = { "SystemAssetID", "SerialBatchNo" })
})
public class EOSystemAsset extends EOObject {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "SystemAssetID")
	private Long sysAssetID;
	@Column(name = "SerialBatchNo", nullable = false)
	private String traceability; //Enable serial/batch no as per the option in Asset Master
	@Column(name = "MaxLife", nullable = false)
	private float opsLife;
	@Column(name = "OperatedLife")
	private float operatedLife;
	@Column(name = "ResidualLife")
	private float residualLife; // residualLife=(Max Life - Operated Life)
	@Column(name = "MTBFBaseline", nullable = false)
	private float mtbfBaseline;
	@Column(name = "MTBFCurrent")
	private float mtbfcurrent;
	@Column(name = "MTTRBaseline", nullable = false)
	private float mttrBaseline;
	@Column(name = "mttrCurrent")
	private float mttrCurrent;
	@Column(name = "Repairable", nullable = false)
	@Enumerated(EnumType.STRING)
	private Repairable repairable;
	@Column(name = "LineReplaceable", nullable = false)
	@Enumerated(EnumType.STRING)
	private Repairable lineReplaceable;
	@Column(name = "CriticalItem", nullable = false)
	@Enumerated(EnumType.STRING)
	private CriticalItem criticalItem;
	@Column(name = "AssetStatus", nullable = false)
	@Enumerated(EnumType.STRING)
	private AssetStatus assetStatus;

	@ManyToOne
	@JoinColumn(name = "AssetMasterID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EOAssetMaster assetId;

	public Long getSysAssetID() {
		return this.sysAssetID;
	}

	public void setSysAssetID(Long sysAssetID) {
		this.sysAssetID = sysAssetID;
	}

	public String getTraceability() {
		return this.traceability;
	}

	public void setTraceability(String traceability) {
		this.traceability = traceability;
	}

	public float getOpsLife() {
		return this.opsLife;
	}

	public void setOpsLife(float opsLife) {
		this.opsLife = opsLife;
	}

	public float getOperatedLife() {
		return this.operatedLife;
	}

	public void setOperatedLife(float operatedLife) {
		this.operatedLife = operatedLife;
	}

	public float getResidualLife() {
		return this.residualLife;
	}

	public void setResidualLife(float residualLife) {
		this.residualLife = residualLife;
	}

	public float getMtbfBaseline() {
		return this.mtbfBaseline;
	}

	public void setMtbfBaseline(float mtbfBaseline) {
		this.mtbfBaseline = mtbfBaseline;
	}

	public float getMtbfcurrent() {
		return this.mtbfcurrent;
	}

	public void setMtbfcurrent(float mtbfcurrent) {
		this.mtbfcurrent = mtbfcurrent;
	}

	public float getMttrBaseline() {
		return this.mttrBaseline;
	}

	public void setMttrBaseline(float mttrBaseline) {
		this.mttrBaseline = mttrBaseline;
	}

	public float getMttrCurrent() {
		return this.mttrCurrent;
	}

	public void setMttrCurrent(float mttrCurrent) {
		this.mttrCurrent = mttrCurrent;
	}

	public Repairable getRepairable() {
		return this.repairable;
	}

	public void setRepairable(Repairable repairable) {
		this.repairable = repairable;
	}

	public Repairable getLineReplaceable() {
		return this.lineReplaceable;
	}

	public void setLineReplaceable(Repairable lineReplaceable) {
		this.lineReplaceable = lineReplaceable;
	}

	public CriticalItem getCriticalItem() {
		return this.criticalItem;
	}

	public void setCriticalItem(CriticalItem criticalItem) {
		this.criticalItem = criticalItem;
	}

	public AssetStatus getAssetStatus() {
		return this.assetStatus;
	}

	public void setAssetStatus(AssetStatus assetStatus) {
		this.assetStatus = assetStatus;
	}

	public EOAssetMaster getAssetId() {
		return this.assetId;
	}

	public void setAssetId(EOAssetMaster assetId) {
		this.assetId = assetId;
	}

}
