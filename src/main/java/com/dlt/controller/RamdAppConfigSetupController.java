package com.dlt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.dlt.enumconstant.ApiErrorCode;
=======
>>>>>>> 0cafe5a7108d2f68ceef800440f635e08371df52
import com.dlt.model.EORamdAppConfigSetup;
import com.dlt.service.RamdAppConfigSetupSvcs;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1/ramdappconfig")
@Api(value = "Ramd AppConfig Setup  API", tags = "Ramd AppConfig Setup API")
public class RamdAppConfigSetupController extends BaseController {

	@Autowired
	private RamdAppConfigSetupSvcs ramdAppConfigSetupSvcs;

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ResponseEntity<Object> getAppConfigData() {
		return this.successResponseForList(this.ramdAppConfigSetupSvcs.getAppConfigData());
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addAppConfig(@RequestBody EORamdAppConfigSetup eoRamdAppConfigSetup) {
		EORamdAppConfigSetup ramdAppConfigSetup = this.ramdAppConfigSetupSvcs.createRamdAppConfig(eoRamdAppConfigSetup);
<<<<<<< HEAD
		return this.successResponseForObj(ramdAppConfigSetup,ApiErrorCode.RAC01);
=======
		return this.successResponseForObj(ramdAppConfigSetup);
>>>>>>> 0cafe5a7108d2f68ceef800440f635e08371df52
	}

}
