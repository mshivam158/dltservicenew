package com.dlt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlt.model.EOUser;
import com.dlt.repos.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	public List<EOUser> getAllUserList() {
		System.out.println("Service Object :" + this);
		return this.userRepo.findAll();
	}
}
