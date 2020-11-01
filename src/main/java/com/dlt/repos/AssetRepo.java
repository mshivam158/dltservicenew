package com.dlt.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlt.model.EOAsset;

@Repository
public interface AssetRepo extends JpaRepository<EOAsset, Long> {

}
