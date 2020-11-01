package com.dlt.service;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.dlt.enumconstant.ApiErrorCode;
import com.dlt.exception.RestValidationException;
import com.dlt.model.EOAssetMaster;
import com.dlt.model.EOAssetMasterList;
import com.dlt.repos.IAssetMasterListRepo;
=======

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlt.model.EOAssetMaster;
>>>>>>> 0cafe5a7108d2f68ceef800440f635e08371df52
import com.dlt.repos.IAssetMasterRepo;
import com.dlt.ui.AssetsMaster;

@Service
public class AssetsMasterTreeSvcs {

	@Autowired
	private IAssetMasterRepo assetsMasterRepo;
<<<<<<< HEAD
	@Autowired
	private IAssetMasterListRepo assetMasterListRepo;

	public Map<String, Object> getTreeStructure(Long masterListId) {
		Map<String, Object> treeMap= new HashMap<String, Object>();
		ArrayList<AssetsMaster> treeView = new ArrayList<AssetsMaster>();
		Optional<EOAssetMasterList> eoAssetMasterList= assetMasterListRepo.findById(masterListId);
		
=======

	public ArrayList<AssetsMaster> getTreeStructure(Long masterListId) {
		ArrayList<AssetsMaster> treeView = new ArrayList<AssetsMaster>();
>>>>>>> 0cafe5a7108d2f68ceef800440f635e08371df52
		ArrayList<EOAssetMaster> assetsMaster = (ArrayList<EOAssetMaster>) this.assetsMasterRepo.getAssetsMasterForMasterList(masterListId);
		assetsMaster.forEach(asset -> {
			AssetsMaster master = this.getAssetsMater(asset);
			treeView.add(master);
		});
<<<<<<< HEAD
		treeMap.put(eoAssetMasterList.get().getAssetMasterName(), treeView);
		return treeMap;
=======
		return treeView;
>>>>>>> 0cafe5a7108d2f68ceef800440f635e08371df52
	}

	private AssetsMaster getAssetsMater(EOAssetMaster eoAssetsMaster) {
		AssetsMaster assetsMaster = new AssetsMaster();
		assetsMaster.setId(eoAssetsMaster.getAssetId());
		assetsMaster.setName(eoAssetsMaster.getNomenclature());
		ArrayList<EOAssetMaster> masterArray = (ArrayList<EOAssetMaster>) this.assetsMasterRepo.findByParentAssetId(eoAssetsMaster);
		if (!masterArray.isEmpty()) {
			masterArray.forEach(eoassetsMaster -> {
				AssetsMaster child = this.getAssetsMater(eoassetsMaster);
				assetsMaster.addChildAssetsMaster(child);
			});
		}
		return assetsMaster;
	}
}
