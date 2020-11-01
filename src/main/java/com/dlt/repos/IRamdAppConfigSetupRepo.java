package com.dlt.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlt.model.EORamdAppConfigSetup;

@Repository
public interface IRamdAppConfigSetupRepo extends JpaRepository<EORamdAppConfigSetup, Long>{

}
