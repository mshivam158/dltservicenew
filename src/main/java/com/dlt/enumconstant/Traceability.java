package com.dlt.enumconstant;

import java.util.HashMap;

public enum Traceability {
	Serialization("Serialization"), Batch("Batch"), BatchSerializ("BatchSerializ"), None("None");

	private String id;

	private Traceability(String id) {
		this.id = id;
	}

	private static HashMap<String, Traceability> traceabilityMap = new HashMap<>();

	static {
		for (Traceability traceability : Traceability.values()) {
			traceabilityMap.put(traceability.id, traceability);
		}
	}

	public static Traceability assetsStatusForID(String id) {
		return traceabilityMap.get(id);
	}
}
