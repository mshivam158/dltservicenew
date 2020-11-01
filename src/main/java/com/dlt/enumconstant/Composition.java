package com.dlt.enumconstant;

import java.util.HashMap;

public enum Composition {
    Plant("Plant"), System("System"), SubSystem("SubSystem"), Equipment("Equipment"), Assembly("Assembly"),Accessory("Accessory"), Part("Part"), Software("software");

	private String id;

	private Composition(String id) {
		this.id = id;
	}

	private static HashMap<String, Composition> compositionMap = new HashMap<>();

	static {
		for (Composition composition : Composition.values()) {
			compositionMap.put(composition.id, composition);
		}
	}

	public static Composition assetsStatusForID(String id) {
		return compositionMap.get(id);
	}
}
