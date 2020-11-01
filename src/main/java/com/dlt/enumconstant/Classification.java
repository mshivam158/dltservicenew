package com.dlt.enumconstant;

import java.util.HashMap;

public enum Classification {
    Furniture("Furniture"), Building("Building"), Electrical("Electrical"), Electronics("Electronics"), Mechanical("Mechanical"),
	Communication("Communication"), Engineering("Engineering"), Computer("Computer"), Infrastructure("Infrastructure"), Transport("Transport"),
	officeEquipment("officeEquipment"), IT_Equipment("IT_Equipment"), Logistics("Logistics");

	private String id;

	private Classification(String id) {
		this.id = id;
	}

	private static HashMap<String, Classification> classificationMap = new HashMap<>();

	static {
		for (Classification classification : Classification.values()) {
			classificationMap.put(classification.id, classification);
		}
	}

	public static Classification assetsStatusForID(String id) {
		return classificationMap.get(id);
	}
}
