package com.dlt.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dlt.model.EOSystemAsset;

@Repository
public interface ISystemAssetRepo extends JpaRepository<EOSystemAsset, Long> {
	
	@Query("select count(e) from EOSystemAsset e where e.assetId.assetId =:pk")
	public long findByAssetMasterPkCount(@Param("pk") Long pk);
}
