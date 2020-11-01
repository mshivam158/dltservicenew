package com.dlt.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dlt.model.EOAssetMaster;

@Repository
public interface IAssetMasterRepo extends JpaRepository<EOAssetMaster, Long> {

	@Query(value = "select e from EOAssetMaster e where e.assetMasterListID.assetMasterListId =:masterPK and (e.parentAssetId is null or e.parentAssetId =0)")
	public List<EOAssetMaster> getAssetsMasterForMasterList(@Param("masterPK") Long masterPK);

	List<EOAssetMaster> findByParentAssetId(EOAssetMaster parentAssetId);
	
	@Query("select count(e) from EOAssetMaster e where e.assetMasterListID.assetMasterListId =:pk")
	public long findByAssetMasterListPkCount(@Param("pk") Long pk);
}
