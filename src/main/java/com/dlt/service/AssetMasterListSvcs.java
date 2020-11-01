package com.dlt.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dlt.enumconstant.ApiErrorCode;
import com.dlt.exception.RestException;
import com.dlt.exception.RestValidationException;
<<<<<<< HEAD
import com.dlt.model.EOAssetMaster;
import com.dlt.model.EOAssetMasterList;
import com.dlt.model.EORamdAppConfigSetup;
import com.dlt.repos.IAssetMasterListRepo;
import com.dlt.repos.IAssetMasterRepo;
=======
import com.dlt.model.EOAssetMasterList;
import com.dlt.model.EORamdAppConfigSetup;
import com.dlt.repos.IAssetMasterListRepo;
>>>>>>> 0cafe5a7108d2f68ceef800440f635e08371df52
import com.dlt.repos.IProjectRepo;
import com.dlt.repos.IRamdAppConfigSetupRepo;

@Service
public class AssetMasterListSvcs {

	@Autowired
	private IAssetMasterListRepo assetMasterListRepo;
	@Autowired
	private IProjectRepo projectRepo;
	@Autowired
<<<<<<< HEAD
	private IAssetMasterRepo assetMasterRepo;
	@Autowired
=======
>>>>>>> 0cafe5a7108d2f68ceef800440f635e08371df52
	private IRamdAppConfigSetupRepo eoRamdAppConfigSetupRepo;

	public HashMap<String, Object> getLooksUpData() {
		HashMap<String, Object> returnMap = new HashMap<>();
		returnMap.put("ASSET_MASTER_LIST", this.assetMasterListRepo.findAll());
		returnMap.put("PROJECTS", this.projectRepo.findAll());
		return returnMap;
	}

	public List<EOAssetMasterList> getAllMasterList() {
		return this.assetMasterListRepo.findAll();
	}
<<<<<<< HEAD
	
	public List<EOAssetMaster> getAssetsMasterFromMasterList(long assetMasterListPk) {
		return this.assetMasterRepo.getAssetsMasterForMasterList(assetMasterListPk);
	}
=======
>>>>>>> 0cafe5a7108d2f68ceef800440f635e08371df52

	public EOAssetMasterList createAssetMasterList(EOAssetMasterList eoAssetMasterListObj) {
		EOAssetMasterList eoAssetMasterList;
		EORamdAppConfigSetup eoRamdAppConfigSetup = this.eoRamdAppConfigSetupRepo.findAll().get(0);
		if (eoAssetMasterListObj.getProjectID() == null || eoAssetMasterListObj.getProjectID().getProjectId() == null) {
<<<<<<< HEAD
			throw new RestValidationException(ApiErrorCode.AMC02);
		}
		if (this.assetMasterListRepo.findByProjectPkCount(
				eoAssetMasterListObj.getProjectID().getProjectId()) == eoRamdAppConfigSetup.getMaxAssetMaster()) {
			throw new RestValidationException(ApiErrorCode.AMC02);
		}
		eoAssetMasterListObj.setAssetMasterNameAndVersion(
				eoAssetMasterListObj.getAssetMasterName() + "-" + eoAssetMasterListObj.getAssetMasterVersion());
=======
			throw new RestValidationException(ApiErrorCode.AMC_04);
		}
		if (this.assetMasterListRepo.findByProjectPkCount(eoAssetMasterListObj.getProjectID().getProjectId()) == eoRamdAppConfigSetup.getMaxAssetMaster()) {
			throw new RestValidationException(ApiErrorCode.AMC02);
		}
		eoAssetMasterListObj.setAssetMasterNameAndVersion(eoAssetMasterListObj.getAssetMasterName() + "-" + eoAssetMasterListObj.getAssetMasterVersion());
>>>>>>> 0cafe5a7108d2f68ceef800440f635e08371df52
		if (eoAssetMasterListObj.getAssetMasterListId() == null) {
			eoAssetMasterListObj.setDateOfCreation(LocalDateTime.now());
		}
		try {
			eoAssetMasterList = this.assetMasterListRepo.save(eoAssetMasterListObj);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return eoAssetMasterList;
	}

	public void deleteAssetMasterList(List<EOAssetMasterList> eoAssetMasterLists) {
<<<<<<< HEAD
		for (EOAssetMasterList eoAssetMasterList : eoAssetMasterLists) {
			if (this.assetMasterRepo.findByAssetMasterListPkCount(eoAssetMasterList.getAssetMasterListId()) == 0) {
				try {
					this.assetMasterListRepo.deleteById(eoAssetMasterList.getAssetMasterListId());
				} catch (Exception e) {
					throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
				}
			}else {
				System.out.println();
				throw new RestValidationException(ApiErrorCode.AMDA01);
			}
=======
		try {
			this.assetMasterListRepo.deleteInBatch(eoAssetMasterLists);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
>>>>>>> 0cafe5a7108d2f68ceef800440f635e08371df52
		}
	}

	public EOAssetMasterList findMasterListByID(Long id) {
		Optional<EOAssetMasterList> option = this.assetMasterListRepo.findById(id);
		if (!option.isPresent()) {
			throw new RestValidationException(ApiErrorCode.AMC404);
		}
		return option.get();
	}

}
