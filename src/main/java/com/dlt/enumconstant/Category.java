package com.dlt.enumconstant;

import java.util.HashMap;

public enum Category {
	Operation("Operation"), Tools("Tools"), Test("Test"), Spares("Spares"), Consumable("Consumable");

	private String id;

	private Category(String id) {
		this.id = id;
	}

	private static HashMap<String, Category> categoryMap = new HashMap<>();

	static {
		for (Category category : Category.values()) {
			categoryMap.put(category.id, category);
		}
	}

	public static Category assetsStatusForID(String id) {
		return categoryMap.get(id);
	}
}
