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

<<<<<<< HEAD
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
=======
>>>>>>> 0cafe5a7108d2f68ceef800440f635e08371df52
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.dlt.enumconstant.Category;
import com.dlt.enumconstant.Classification;
import com.dlt.enumconstant.Composition;
import com.dlt.enumconstant.Denomination;
import com.dlt.enumconstant.LifeMeasure;
import com.dlt.enumconstant.Traceability;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EOAssetMaster extends EOObject {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AssetID")
	private Long assetId;
	@Column(name = "Nomenclature", nullable = false)
	private String nomenclature;
	@Column(name = "DrawingNo", nullable = false)
	private String drawingNo;
	@Column(name = "DrawingItemReference", nullable = false)
	private String drawingItemReference;
	@Column(name = "PartNumber", nullable = false)
	private String partNumber;
	@Column(name = "Model", nullable = false)
	private String model;
	@Column(name = "Manufacturer", nullable = false)
	private String manufacturer;
	@Column(name = "Classification", nullable = false)
	@Enumerated(EnumType.STRING)
	public Classification classification;
	@Column(name = "Category")
	@Enumerated(EnumType.STRING)
	private Category category;
	@Column(name = "Composition", nullable = false)
	@Enumerated(EnumType.STRING)
	private Composition composition;
	@Column(name = "Traceability", nullable = false)
	@Enumerated(EnumType.STRING)
	private Traceability traceability;
	@Column(name = "Denomination", nullable = false)
	private Denomination denomination;
	@Column(name = "LifeMeasure", nullable = false)
	@Enumerated(EnumType.STRING)
	private LifeMeasure lifeMeasure;

<<<<<<< HEAD

	@JoinColumn(name = "ParentAssetID")
	@ManyToOne
	@Cascade({CascadeType.REMOVE, CascadeType.SAVE_UPDATE})	
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EOAssetMaster parentAssetId;
	
	
	
=======
	@JoinColumn(name = "ParentAssetID")
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EOAssetMaster parentAssetId;

>>>>>>> 0cafe5a7108d2f68ceef800440f635e08371df52
	public EOAssetMaster getParentAssetId() {
		return this.parentAssetId;
	}

	public void setParentAssetId(EOAssetMaster parentAssetId) {
		this.parentAssetId = parentAssetId;
	}

	@ManyToOne
	@JoinColumn(name = "AssetMasterListID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EOAssetMasterList assetMasterListID;

	public Long getAssetId() {
		return this.assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}

	public String getNomenclature() {
		return this.nomenclature;
	}

	public void setNomenclature(String nomenclature) {
		this.nomenclature = nomenclature;
	}

	public String getDrawingNo() {
		return this.drawingNo;
	}

	public void setDrawingNo(String drawingNo) {
		this.drawingNo = drawingNo;
	}

	public String getDrawingItemReference() {
		return this.drawingItemReference;
	}

	public void setDrawingItemReference(String drawingItemReference) {
		this.drawingItemReference = drawingItemReference;
	}

	public String getPartNumber() {
		return this.partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Classification getClassification() {
		return this.classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Composition getComposition() {
		return this.composition;
	}

	public void setComposition(Composition composition) {
		this.composition = composition;
	}

	public Traceability getTraceability() {
		return this.traceability;
	}

	public void setTraceability(Traceability traceability) {
		this.traceability = traceability;
	}

	public Denomination getDenomination() {
		return this.denomination;
	}

	public void setDenomination(Denomination denomination) {
		this.denomination = denomination;
	}

	public LifeMeasure getLifeMeasure() {
		return this.lifeMeasure;
	}

	public void setLifeMeasure(LifeMeasure lifeMeasure) {
		this.lifeMeasure = lifeMeasure;
	}

	public EOAssetMasterList getAssetMasterListID() {
		return this.assetMasterListID;
	}

	public void setAssetMasterListID(EOAssetMasterList assetMasterListID) {
		this.assetMasterListID = assetMasterListID;
	}

}
