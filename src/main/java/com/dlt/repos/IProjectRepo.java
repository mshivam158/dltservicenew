package com.dlt.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dlt.model.EOProject;

@Repository
public interface IProjectRepo extends JpaRepository<EOProject, Long> {
	
	@Query(name = "findByClientAccount")
	public List<EOProject> findByClientAccount(@Param("clientPK") Long clientId);
	
	@Query("select count(e) from EOProject e where e.clientId.clientId =:pk")
	public long findByClientPkCount(@Param("pk") Long pk);
}
