package com.dlt.enumconstant;

public enum ApiErrorCode {
	AMC01("AMC01", "User Not Authorized for this operation"),
	AMC02("AMC02", "Failed the addition of New Entry if it is above the upper limit"),
	AMC03("AMC03", "Next state is not Possible at this state"),
<<<<<<< HEAD
	AMC404("AMC404", "Object Not Found for given Id"),
	
	//project message
	PAC_01("PAC01","Project Added Successfully."),
	PAC_02("PAC02","Project ID is mendatory"),
	
	//client account message
	CAC_01("CAC01", "Client Account Added Successfully."),
	CAC_02("CAC02", "Client ID is mendatory."),
	
	//Ramd System Config
	AMRSC01("AMRSC01", "Can't create more than 1 Row in Ramd App config setup"),
	RAC01("RAC01", "App Config Added Successfully."),

    // system Asset message
	SAC_01("SAC01", "System Asset Added Successfully."),
	SAC_02("SAC02","Asset Master ID is mendatory"),
	
	//Asset master message
	AMC_01("AMC01","Asset Master Added Successfully."),
	AMDA01("AMDA01", "Asset master list is not deleted because Master Assets is present in this list."),
	AMC_02("AMC02","Asset Master ID is mendatory"),
	
	//Asset master List message
	AMLC_01("AMLC01","Asset Master List Added Successfully."),
	AMLC_02("AMLC02","Asset Master List ID is mendatory"),
	AMLC_03("AMLC03", "Record exists already. Please use different name or version.");
    
=======
	AMC_04(
			"AMC04",
			"Project ID is mendatory"),
	AMC404("AMC404", "Object Not Found for given Id"),
	//System Assets
	AMSA01("AMSA01", "Master Assets ID is mendatory"),
	//Ramd System Config
	AMRSC01("AMRSC01", "Can't create more than 1 Row in Ramd App config setup");

>>>>>>> 0cafe5a7108d2f68ceef800440f635e08371df52
	private ApiErrorCode(String id, String msg) {
		this.id = id;
		this.msg = msg;
	}

	private String id;
	private String msg;

	public String getMsg() {
		return this.msg;
	}

	public String getId() {
		return this.id;
	}
}
