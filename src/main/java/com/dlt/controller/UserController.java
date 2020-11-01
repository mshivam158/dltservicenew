package com.dlt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dlt.exception.RestException;
import com.dlt.model.EOUser;
import com.dlt.repos.UserRepo;
import com.dlt.service.UserService;

@RestController
@RequestMapping(path = "/v1/user")
public class UserController extends BaseController {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private UserService userService;

	@RequestMapping(path = "/adduser", method = RequestMethod.POST)
	public EOUser addUser(@RequestBody EOUser eoUser) {
		return this.userRepo.save(eoUser);
	}

	@RequestMapping(path = "/getusers", method = RequestMethod.GET)
	public List<EOUser> getUsers() {
		return this.userService.getAllUserList();
	}

	@RequestMapping(path = "/deleteuser/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUser(@PathVariable("id") long id) {
		if (id < 1) {
			throw new RestException("supplied pk cann't be Zero or negative", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		try {
			this.userRepo.deleteById(id);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return this.deleteSuccess();
	}
}
