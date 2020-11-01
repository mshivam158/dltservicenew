package com.dlt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dlt.enumconstant.ApiErrorCode;
import com.dlt.enumconstant.Status;
import com.dlt.exception.RestException;
import com.dlt.exception.RestValidationException;
import com.dlt.model.EOClientAccount;
import com.dlt.model.EORamdAppConfigSetup;
import com.dlt.repos.IClientAccountRepo;
import com.dlt.repos.IRamdAppConfigSetupRepo;

@Service
public class ClientAccountSvcs {

	@Autowired
	private IClientAccountRepo IClientAccountRepo;
	@Autowired
	private IRamdAppConfigSetupRepo eoRamdAppConfigSetupRepo;

	public HashMap<String, Object> getClientData() {
		HashMap<String, Object> returnMap = new HashMap<>();
		returnMap.put("STATUS", Status.values());
		returnMap.put("CLIENT_ACCOUNT_LIST", this.IClientAccountRepo.findAll());
		return returnMap;
	}

	public EOClientAccount createClientAccount(EOClientAccount eoClientAccount) {
		EOClientAccount eoAccount;
		EORamdAppConfigSetup eoRamdAppConfigSetup = this.eoRamdAppConfigSetupRepo.findAll().get(0);
		if (this.IClientAccountRepo.count() == eoRamdAppConfigSetup.getMaxClientAccount()) {
			throw new RestValidationException(ApiErrorCode.AMC02);
		}
		try {
			eoClientAccount.setClientStatus(Status.Created);
			eoAccount = this.IClientAccountRepo.save(eoClientAccount);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return eoAccount;
	}

	public void deleteClientAcc(List<EOClientAccount> eoClientAccounts) {
		try {
			this.IClientAccountRepo.deleteInBatch(eoClientAccounts);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	public EOClientAccount updateClientObject(EOClientAccount clientAccount, Long pk) {
		EOClientAccount eoClientAccount = null;
		Optional<EOClientAccount> optionalClientAcc = this.IClientAccountRepo.findById(pk);
		if (!optionalClientAcc.isPresent()) {
			throw new RestValidationException(ApiErrorCode.AMC404);
		}
		try {
			clientAccount.setClientId(pk);
			eoClientAccount = this.IClientAccountRepo.save(clientAccount);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return eoClientAccount;
	}
}
