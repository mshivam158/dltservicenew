package com.dlt.enumconstant;

import java.util.HashMap;

public enum Denomination {
    Each("Each"), Pair("Pair"), Set("Set"), Meter("Meter"), SquareMeter("SquareMeter"),Kilogram("Kilogram"), Litre("Litre");

	private String id;

	private Denomination(String id) {
		this.id = id;
	}

	private static HashMap<String, Denomination> denominationMap = new HashMap<>();

	static {
		for (Denomination denomination : Denomination.values()) {
			denominationMap.put(denomination.id, denomination);
		}
	}

	public static Denomination assetsStatusForID(String id) {
		return denominationMap.get(id);
	}
}
