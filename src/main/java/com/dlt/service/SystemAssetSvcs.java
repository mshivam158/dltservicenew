package com.dlt.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dlt.enumconstant.ApiErrorCode;
import com.dlt.enumconstant.AssetStatus;
import com.dlt.enumconstant.CriticalItem;
import com.dlt.enumconstant.Repairable;
import com.dlt.exception.RestException;
import com.dlt.exception.RestValidationException;
import com.dlt.model.EORamdAppConfigSetup;
import com.dlt.model.EOSystemAsset;
import com.dlt.repos.IAssetMasterRepo;
import com.dlt.repos.IRamdAppConfigSetupRepo;
import com.dlt.repos.ISystemAssetRepo;

@Service
public class SystemAssetSvcs {

	@Autowired
	private ISystemAssetRepo systemAssetRepo;
	@Autowired
	private IAssetMasterRepo assetMasterRepo;
	@Autowired
	private IRamdAppConfigSetupRepo eoRamdAppConfigSetupRepo;

	public HashMap<String, Object> getLookupData() {
		HashMap<String, Object> returnMap = new HashMap<>();
		returnMap.put("AssetsStatus", AssetStatus.values());
		returnMap.put("CriticalItem", CriticalItem.values());
		returnMap.put("Repairable", Repairable.values());
		returnMap.put("ASSET_MASTER", this.assetMasterRepo.findAll());
		returnMap.put("SYSTEM_ASSET", this.systemAssetRepo.findAll());
		return returnMap;
	}

	public List<EOSystemAsset> getAllSystemAssets() {
		return this.systemAssetRepo.findAll();
	}

	public EOSystemAsset createSystemAsset(EOSystemAsset eoSystmAsset) {
		EOSystemAsset eoAssetObj;
		EORamdAppConfigSetup eoRamdAppConfigSetup = this.eoRamdAppConfigSetupRepo.findAll().get(0);
		if (eoSystmAsset.getAssetId() == null || eoSystmAsset.getAssetId().getAssetId() == null) {
<<<<<<< HEAD
			throw new RestValidationException(ApiErrorCode.AMC02);
=======
			throw new RestValidationException(ApiErrorCode.AMSA01);
>>>>>>> 0cafe5a7108d2f68ceef800440f635e08371df52
		}
		if (this.systemAssetRepo.findByAssetMasterPkCount(eoSystmAsset.getAssetId().getAssetId()) == eoRamdAppConfigSetup.getMaxAssetMaster()) {
			throw new RestValidationException(ApiErrorCode.AMC02);
		}
		eoSystmAsset.setResidualLife(eoSystmAsset.getOpsLife() - eoSystmAsset.getOperatedLife());
		if (eoSystmAsset.getSysAssetID() != null) {
			EOSystemAsset eoAsset = this.systemAssetRepo.findById(eoSystmAsset.getSysAssetID()).get();
			if ((eoAsset.getAssetStatus() == AssetStatus.Operational) && (eoSystmAsset.getAssetStatus() != AssetStatus.Uninstalled)) {
				throw new RestValidationException(ApiErrorCode.AMC03);
			}
			if ((eoAsset.getAssetStatus() == AssetStatus.Failed) && (eoSystmAsset.getAssetStatus() != AssetStatus.Maintenance)) {
				throw new RestValidationException(ApiErrorCode.AMC03);
			}
			if ((eoAsset.getAssetStatus() == AssetStatus.Installed) && (eoSystmAsset.getAssetStatus() != AssetStatus.Uninstalled) || (eoSystmAsset.getAssetStatus() != AssetStatus.Expired)) {
				throw new RestValidationException(ApiErrorCode.AMC03);
			}
			if ((eoAsset.getAssetStatus() == AssetStatus.Any) && ((eoSystmAsset.getAssetStatus() != AssetStatus.Failed) || (eoSystmAsset.getAssetStatus() != AssetStatus.Expired))) {
				throw new RestValidationException(ApiErrorCode.AMC03);
			}
			if ((eoAsset.getAssetStatus() == AssetStatus.Any) && ((eoSystmAsset.getAssetStatus() != AssetStatus.Failed) || (eoSystmAsset.getAssetStatus() != AssetStatus.Expired))) {
				throw new RestValidationException(ApiErrorCode.AMC03);
			}
		}
		try {
			eoAssetObj = this.systemAssetRepo.save(eoSystmAsset);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return eoAssetObj;
	}

	public void deleteSystemAsset(List<EOSystemAsset> eoSystemAssets) {
		try {
			this.systemAssetRepo.deleteInBatch(eoSystemAssets);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}
}
