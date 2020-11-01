package com.dlt.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.dlt.enumconstant.ApiErrorCode;
=======
>>>>>>> 0cafe5a7108d2f68ceef800440f635e08371df52
import com.dlt.model.EOClientAccount;
import com.dlt.service.ClientAccountSvcs;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1/clientaccount")
@Api(value = "Client Account API", tags = "Client Account API")
public class ClientAccountController extends BaseController {
	@Autowired
	private ClientAccountSvcs clientAccountSvcs;

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public HashMap<String, Object> getClientAccounts() {
		return this.clientAccountSvcs.getClientData();
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addClientAccount(@RequestBody EOClientAccount eoClientAccount) {
		EOClientAccount eoClientAcount = this.clientAccountSvcs.createClientAccount(eoClientAccount);
<<<<<<< HEAD
		return this.successResponseForObj(eoClientAcount,ApiErrorCode.CAC_01);
=======
		return this.successResponseForObj(eoClientAcount);
>>>>>>> 0cafe5a7108d2f68ceef800440f635e08371df52
	}

	@RequestMapping(path = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteClientAccount(@RequestBody List<EOClientAccount> eoClientAccounts) {
		this.clientAccountSvcs.deleteClientAcc(eoClientAccounts);
		return this.deleteSuccess();
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateClientAccount(@RequestBody EOClientAccount eoClientAccount, @PathVariable("id") Long id) {
		EOClientAccount clientAccount = this.clientAccountSvcs.updateClientObject(eoClientAccount, id);
<<<<<<< HEAD
		return this.successResponseForObj(clientAccount,ApiErrorCode.CAC_01);
=======
		return this.successResponseForObj(clientAccount);
>>>>>>> 0cafe5a7108d2f68ceef800440f635e08371df52
	}
}
