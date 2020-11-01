package com.dlt.enumconstant;

import java.util.HashMap;

public enum AssetStatus {
	Operational("Operational"), Maintenance("Maintenance"),Any("Any"), Failed("Failed"), Uninstalled("Uninstalled"),Installed("Installed"), Expired("Expired");

	private String id;

	private AssetStatus(String id) {
		this.id = id;
	}

	private static HashMap<String, AssetStatus> assetsStatusMap = new HashMap<>();

	static {
		for (AssetStatus assets : AssetStatus.values()) {
			assetsStatusMap.put(assets.id, assets);
		}
	}

	public static AssetStatus assetsStatusForID(String id) {
		return assetsStatusMap.get(id);
	}
}
