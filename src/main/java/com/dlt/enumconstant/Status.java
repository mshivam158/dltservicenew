package com.dlt.enumconstant;

import java.util.HashMap;

public enum Status {
	Created("Created"), Active("Active"), Closed("Closed"),Any("Any"),Expired("Expired");

	private String id;

	private Status(String id) {
		this.id = id;
	}

	private static HashMap<String, Status> statusMap = new HashMap<>();

	static {
		for (Status status : Status.values()) {
			statusMap.put(status.id, status);
		}
	}

	public static Status statusForID(String id) {
		return statusMap.get(id);
	}
}
