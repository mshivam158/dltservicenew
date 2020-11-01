package com.dlt.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dlt.enumconstant.ApiErrorCode;
import com.dlt.model.EOProject;
import com.dlt.service.ProjectSvcs;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1/project")
@Api(value = "Project API", tags = "Project API")
public class ProjectController extends BaseController {

	@Autowired
	private ProjectSvcs projectSvcs;

	@RequestMapping(path = "/getlookup", method = RequestMethod.GET)
	public HashMap<String, Object> getProjectData() {
		return this.projectSvcs.getLokksUpData();
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addProject(@RequestBody EOProject eoProject) {
		EOProject eoProjct = this.projectSvcs.createProject(eoProject);
		return this.successResponseForObj(eoProjct, ApiErrorCode.PAC_01);
	}

	@RequestMapping(path = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProjects(@RequestBody List<EOProject> proList) {
		this.projectSvcs.deleteProjects(proList);
		return this.deleteSuccess();
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProject(@RequestBody EOProject project, @PathVariable("id") Long id) {
		EOProject eoProject = this.projectSvcs.updateProject(project, id);
		return this.successResponseForObj(eoProject, ApiErrorCode.PAC_01);
	}

}
