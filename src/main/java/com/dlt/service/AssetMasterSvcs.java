package com.dlt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dlt.enumconstant.ApiErrorCode;
import com.dlt.enumconstant.Category;
import com.dlt.enumconstant.Classification;
import com.dlt.enumconstant.Composition;
import com.dlt.enumconstant.Denomination;
import com.dlt.enumconstant.LifeMeasure;
import com.dlt.enumconstant.Traceability;
import com.dlt.exception.RestException;
import com.dlt.exception.RestValidationException;
import com.dlt.model.EOAssetMaster;
import com.dlt.model.EORamdAppConfigSetup;
import com.dlt.repos.IAssetMasterListRepo;
import com.dlt.repos.IAssetMasterRepo;
import com.dlt.repos.IRamdAppConfigSetupRepo;

@Service
public class AssetMasterSvcs {

	@Autowired
	private IAssetMasterRepo assetMasterRepo;
	@Autowired
	private IAssetMasterListRepo assetMasterListRepo;
	@Autowired
	private IRamdAppConfigSetupRepo eoRamdAppConfigSetupRepo;

	public HashMap<String, Object> getLookupData() {
		HashMap<String, Object> returnMap = new HashMap<>();
		returnMap.put("Classification", Classification.values());
		returnMap.put("Category", Category.values());
		returnMap.put("Composition", Composition.values());
		returnMap.put("Traceability", Traceability.values());
		returnMap.put("Denomination", Denomination.values());
		returnMap.put("LifeMeasure", LifeMeasure.values());
		returnMap.put("ASSET_MASTER", this.assetMasterRepo.findAll());
		returnMap.put("ASSET_MASTER_LIST", this.assetMasterListRepo.findAll());
		return returnMap;
	}

	public EOAssetMaster createAssetMaster(EOAssetMaster eoAssetMaster) {
		EOAssetMaster eoAssetMasterObj;
		EORamdAppConfigSetup eoRamdAppConfigSetup = this.eoRamdAppConfigSetupRepo.findAll().get(0);
		if (this.assetMasterRepo.findByAssetMasterListPkCount(eoAssetMaster.getAssetMasterListID().getAssetMasterListId()) == eoRamdAppConfigSetup.getMaxAssetMaster()) {
			throw new RestValidationException(ApiErrorCode.AMC02);
		}
		try {
			eoAssetMasterObj = this.assetMasterRepo.save(eoAssetMaster);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return eoAssetMasterObj;
	}

	public void deleteAssetMaster(List<EOAssetMaster> eoAssetMasters) {
		try {
			this.assetMasterRepo.deleteInBatch(eoAssetMasters);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	public EOAssetMaster findAssetsMasterByID(Long id) {
		Optional<EOAssetMaster> option = this.assetMasterRepo.findById(id);
		if (!option.isPresent()) {
			throw new RestValidationException(ApiErrorCode.AMC404);
		}
		return option.get();
	}
}
