package com.regional.property.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.regional.property.model.Role;
import com.regional.property.model.Status;
import com.regional.property.services.RoleService;

@Controller
@RequestMapping("role")
@Api(value = "This controller will deal with Role module")
public class RoleController {

	private static final Logger logger = Logger.getLogger(RoleController.class);

	@Autowired
	private RoleService	roleService;

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@RequestMapping(value = "/createrole", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Role createRole(@RequestBody Role role) {
		try {
			role=roleService.createRole(role);
			return role;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return role;

	}

	@ApiOperation(value = "Gets a Role based on role id", 
			notes = "Retrieves a single Role", response = Role.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Role getRole(@PathVariable("id") long id) {
		Role role = null;
		try {
			role = roleService.getRoleById(id);

		} catch (Exception exception) {
			logger.error(exception);
		}
		return role;
	}

	@RequestMapping(value = "/rolelist", method = RequestMethod.GET)
	public @ResponseBody
	List<Role> getRoleList() {

		List<Role> roleList = null;
		try {
			roleList = roleService.getRoleList();

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(exception);
		}
		return roleList;
	}

	@ApiOperation(value = "Delete a Role based on role id", 
			notes = "Delete a single Role i.e. it changes its 'deleted' flag to true ", response = Role.class)
	@RequestMapping(value = "deleterole/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteRole(@PathVariable("id") long id) {

		try {
			roleService.deleteRole(id);
			return new Status(1, "role deleted Successfully !");
		} catch (Exception exception) {
			logger.error(exception);
		}
		return null;

	}
}
