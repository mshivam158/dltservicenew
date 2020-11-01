package com.dlt.service;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dlt.enumconstant.ApiErrorCode;
import com.dlt.exception.RestException;
import com.dlt.exception.RestValidationException;
import com.dlt.model.EORamdAppConfigSetup;
import com.dlt.repos.IRamdAppConfigSetupRepo;

@Service
public class RamdAppConfigSetupSvcs {

	@Autowired
	private IRamdAppConfigSetupRepo eoRamdAppConfigSetupRepo;

	public ArrayList<EORamdAppConfigSetup> getAppConfigData() {
		return (ArrayList<EORamdAppConfigSetup>) this.eoRamdAppConfigSetupRepo.findAll();
	}

	public EORamdAppConfigSetup createRamdAppConfig(EORamdAppConfigSetup eoRamdAppConfigSetup) {
		if (!this.eoRamdAppConfigSetupRepo.findAll().isEmpty()) {
			throw new RestValidationException(ApiErrorCode.AMRSC01);
		}
		EORamdAppConfigSetup eoRamdAppConfgSetup;
		try {
			eoRamdAppConfgSetup = this.eoRamdAppConfigSetupRepo.save(eoRamdAppConfigSetup);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return eoRamdAppConfgSetup;
	}

	@PostConstruct
	public void defaultLoad() {
		// create a default object...
		if (this.eoRamdAppConfigSetupRepo.findAll().isEmpty()) {
			EORamdAppConfigSetup setup = new EORamdAppConfigSetup();
			this.createRamdAppConfig(setup);
		}
	}

}
