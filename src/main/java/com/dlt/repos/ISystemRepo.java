package com.dlt.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlt.model.EOSystem;

@Repository
public interface ISystemRepo extends JpaRepository<EOSystem, Long> {

}
