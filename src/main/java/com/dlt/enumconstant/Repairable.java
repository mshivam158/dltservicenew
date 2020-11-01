package com.dlt.enumconstant;

import java.util.HashMap;

public enum Repairable {
	Yes("Yes"), No("No"), ;

	private String id;

	private Repairable(String id) {
		this.id = id;
	}

	private static HashMap<String, Repairable> repairableMap = new HashMap<>();

	static {
		for (Repairable repairable : Repairable.values()) {
			repairableMap.put(repairable.id, repairable);
		}
	}

	public static Repairable assetsStatusForID(String id) {
		return repairableMap.get(id);
	}
}
