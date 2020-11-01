package com.dlt.enumconstant;

import java.util.HashMap;

public enum DLPReporting {

	Monthly("Monthly"), Quarteryly("Quarteryly"), HalfYearly("Half-Yearly");

	private String id;

	private DLPReporting(String id) {
		this.id = id;
	}

	private static HashMap<String, DLPReporting> dlpReportingMap = new HashMap<>();

	static {
		for (DLPReporting dlpReporting : DLPReporting.values()) {
			dlpReportingMap.put(dlpReporting.id, dlpReporting);
		}
	}

	public static DLPReporting statusForID(String id) {
		return dlpReportingMap.get(id);
	}
}
