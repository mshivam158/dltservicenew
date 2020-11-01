package com.dlt.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlt.model.EOUser;

@Repository
public interface UserRepo extends JpaRepository<EOUser, Long> {

}
