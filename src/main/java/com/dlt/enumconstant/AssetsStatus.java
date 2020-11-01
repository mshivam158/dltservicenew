package com.dlt.enumconstant;

import java.util.HashMap;

public enum AssetsStatus {
	Operational("Operational"), Maintenance("Maintenance"), Failed("Failed"), Uninstalled("Uninstalled"), Expired("Expired");

	private String id;

	private AssetsStatus(String id) {
		this.id = id;
	}

	private static HashMap<String, AssetsStatus> assetsStatusMap = new HashMap<>();

	static {
		for (AssetsStatus assets : AssetsStatus.values()) {
			assetsStatusMap.put(assets.id, assets);
		}
	}

	public static AssetsStatus assetsStatusForID(String id) {
		return assetsStatusMap.get(id);
	}
}
