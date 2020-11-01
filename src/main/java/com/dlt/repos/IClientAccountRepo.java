package com.dlt.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlt.model.EOClientAccount;

@Repository
public interface IClientAccountRepo extends JpaRepository<EOClientAccount, Long>{

}
