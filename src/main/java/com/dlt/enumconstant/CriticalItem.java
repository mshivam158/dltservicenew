package com.dlt.enumconstant;

import java.util.HashMap;

public enum CriticalItem {
     Reliability("Reliability"), Safety("Safety"), None("None");

	private String id;

	private CriticalItem(String id) {
		this.id = id;
	}

	private static HashMap<String, CriticalItem> criticalItemMap = new HashMap<>();

	static {
		for (CriticalItem criticalItem : CriticalItem.values()) {
			criticalItemMap.put(criticalItem.id, criticalItem);
		}
	}

	public static CriticalItem assetsStatusForID(String id) {
		return criticalItemMap.get(id);
	}
}
