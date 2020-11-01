package com.dlt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlt.repos.ISystemRepo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SystemSvcs {
	@Autowired
	private ISystemRepo systemRepos;

	public long findAllEligibleSystems() {
		System.out.println("call all eligible systems");
		System.out.println("system repos :" + this.systemRepos);
		return this.systemRepos.count();
	}
}
