package com.dlt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dlt.enumconstant.ApiErrorCode;
import com.dlt.enumconstant.DLPReporting;
import com.dlt.enumconstant.Status;
import com.dlt.exception.RestException;
import com.dlt.exception.RestValidationException;
import com.dlt.model.EOProject;
import com.dlt.model.EORamdAppConfigSetup;
import com.dlt.repos.IProjectRepo;
import com.dlt.repos.IRamdAppConfigSetupRepo;

@Service
public class ProjectSvcs {

	@Autowired
	private IProjectRepo projectRepo;
	@Autowired
	private IRamdAppConfigSetupRepo eoRamdAppConfigSetupRepo;

	public HashMap<String, Object> getLokksUpData() {
		HashMap<String, Object> returnMap = new HashMap<>();
		returnMap.put("STATUS", Status.values());
		returnMap.put("DLP_REPORTING", DLPReporting.values());
		returnMap.put("PROJECTS", this.projectRepo.findAll());
		return returnMap;
	}

	public EOProject createProject(EOProject eoProject) {
		EOProject eoProjectObj;
		EORamdAppConfigSetup eoRamdAppConfigSetup = this.eoRamdAppConfigSetupRepo.findAll().get(0);
		if (this.projectRepo.findByClientPkCount(eoProject.getClientId().getClientId()) == eoRamdAppConfigSetup.getMaxProject()) {
			throw new RestValidationException(ApiErrorCode.AMC02);
		}
		if (eoProject.getProjectId() != null) {
			EOProject eoProject2 = this.projectRepo.findById(eoProject.getProjectId()).get();
			if ((eoProject2.getStatus() == Status.Created) && eoProject.getStatus() == Status.Active)
				throw new RestValidationException(ApiErrorCode.AMC03);
			if ((eoProject2.getStatus() == Status.Any) && eoProject.getStatus() == Status.Closed)
				throw new RestValidationException(ApiErrorCode.AMC03);
		}
		try {
			eoProjectObj = this.projectRepo.save(eoProject);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return eoProjectObj;
	}

	public void deleteProjects(List<EOProject> proList) {
		try {
			this.projectRepo.deleteInBatch(proList);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	public EOProject updateProject(EOProject project, Long pk) {
		EOProject eoProject = null;
		Optional<EOProject> projectOpt = this.projectRepo.findById(pk);
		if (!projectOpt.isPresent()) {
			throw new RestValidationException(ApiErrorCode.AMC404);
		}
		try {
			project.setProjectId(pk);
			eoProject = this.projectRepo.save(project);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return eoProject;
	}
}
