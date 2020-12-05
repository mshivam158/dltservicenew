package com.dlt.service;

import java.util.ArrayList;
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
import com.dlt.repos.IAssetMasterRepo;
import com.dlt.ui.AssetsMaster;

@Service
public class AssetsMasterTreeSvcs {

	@Autowired
	private IAssetMasterRepo assetsMasterRepo;
	@Autowired
	private IAssetMasterListRepo assetMasterListRepo;

	public ArrayList<Object> getTreeStructure(Long masterListId) {
		Map<String, Object> treeMap= new HashMap<String, Object>();
		ArrayList<Object> returnList = new ArrayList<Object>();
		ArrayList<AssetsMaster> treeView = new ArrayList<AssetsMaster>();
		Optional<EOAssetMasterList> eoAssetMasterList= assetMasterListRepo.findById(masterListId);
		
		ArrayList<EOAssetMaster> assetsMaster = (ArrayList<EOAssetMaster>) this.assetsMasterRepo.getAssetsMasterForMasterList(masterListId);
		assetsMaster.forEach(asset -> {
			AssetsMaster master = this.getAssetsMater(asset);
			treeView.add(master);
		});
		treeMap.put("name", eoAssetMasterList.get().getAssetMasterName());
		treeMap.put("id", eoAssetMasterList.get().getAssetMasterListId());
		treeMap.put("children", treeView);
		returnList.add(treeMap);
		//treeMap.put(eoAssetMasterList.get().getAssetMasterName(), treeView);
		return returnList;
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
