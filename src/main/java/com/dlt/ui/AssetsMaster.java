package com.dlt.ui;

import java.io.Serializable;
import java.util.ArrayList;

public class AssetsMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private boolean isAssetsMasterList;

	public boolean isAssetsMasterList() {
		return this.isAssetsMasterList;
	}

	public void setAssetsMasterList(boolean isAssetsMasterList) {
		this.isAssetsMasterList = isAssetsMasterList;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private ArrayList<AssetsMaster> children = new ArrayList<>();

	public void addChildAssetsMaster(AssetsMaster childMaster) {
		this.children.add(childMaster);
	}

	public ArrayList<AssetsMaster> getChildren() {
		return this.children;
	}

	public void setChildren(ArrayList<AssetsMaster> children) {
		this.children = children;
	}
}
