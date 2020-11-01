package com.dlt.enumconstant;

import java.util.HashMap;

public enum AssetLife {
	OpsHours("Ops Hours"), OpsCycles("Ops Cycles"), OpsDay("Ops Day"), OpsMiles("Ops Miles"), OpsKm("Ops Km"), OnCondition("On Condition");

	private String id;

	private AssetLife(String id) {
		this.id = id;
	}

	private static HashMap<String, AssetLife> assetsLifeMap = new HashMap<>();

	static {
		for (AssetLife assets : AssetLife.values()) {
			assetsLifeMap.put(assets.id, assets);
		}
	}

	public static AssetLife assetsStatusForID(String id) {
		return assetsLifeMap.get(id);
	}

}
