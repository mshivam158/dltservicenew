package com.dlt.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dlt.model.EOAssetMasterList;

@Repository
public interface IAssetMasterListRepo extends JpaRepository<EOAssetMasterList, Long> {
	@Query(name = "findByProjectPk")
	public List<EOAssetMasterList> findByProjectPk(@Param("projectPK") Long projectPK);

	@Query(name = "findByProjectPkCount")
	public long findByProjectPkCount(@Param("projectPK") Long projectPK);
}
