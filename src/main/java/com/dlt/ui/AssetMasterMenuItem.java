package com.dlt.ui;

import java.io.Serializable;

public class AssetMasterMenuItem implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long assetMasterListId;
	private String assetMasterName;

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

	public String getAssetMasterNameAndVersion() {
		return this.assetMasterNameAndVersion;
	}

	public void setAssetMasterNameAndVersion(String assetMasterNameAndVersion) {
		this.assetMasterNameAndVersion = assetMasterNameAndVersion;
	}

	private String assetMasterNameAndVersion;

}
