package com.dlt.enumconstant;

import java.util.HashMap;

public enum LifeMeasure {	
	OpsHours("OpsHours"), OpsCycles("OpsCycles"), OpsDay("OpsDay"), OpsMiles("OpsMiles"), OpsKm("OpsKm"),OnCondition("OnCondition");

	private String id;

	private LifeMeasure(String id) {
		this.id = id;
	}

	private static HashMap<String, LifeMeasure> assetsLifeMap = new HashMap<>();

	static {
		for (LifeMeasure assets : LifeMeasure.values()) {
			assetsLifeMap.put(assets.id, assets);
		}
	}

	public static LifeMeasure assetsStatusForID(String id) {
		return assetsLifeMap.get(id);
	}
	
}
