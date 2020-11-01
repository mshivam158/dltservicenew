package com.dlt.service;

import org.springframework.stereotype.Service;

import com.dlt.repos.IProjectInfoRepo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProjectInfoSvcs {
	//@Autowired
	private IProjectInfoRepo projectInfoRepos;
}
