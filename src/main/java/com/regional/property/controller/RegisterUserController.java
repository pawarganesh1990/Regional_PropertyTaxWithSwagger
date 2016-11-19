package com.regional.property.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.regional.property.model.RegUsers;
import com.regional.property.model.Role;
import com.regional.property.model.Status;
import com.regional.property.model.UserRoles;
import com.regional.property.services.RegisterUserService;
import com.regional.property.services.RoleService;
import com.regional.property.services.UserRoleService;

@Controller
@RequestMapping("user")
@Api(value = "This controller will deal with User module")
public class RegisterUserController {
	private static final Logger logger = Logger.getLogger(RegisterUserController.class);
	@Autowired
	private RegisterUserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserRoleService userRoleService;
	@Value("${aes.secretkey}") 
	String AESKey;

	public UserRoleService getUserRoleService() {
		return userRoleService;
	}


	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}


	public RoleService getRoleService() {
		return roleService;
	}


	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}


	public RegisterUserService getUserService() {
		return userService;
	}


	public void setUserService(RegisterUserService userService) {
		this.userService = userService;
	}


	@RequestMapping(value = "/createUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	RegUsers createUser(@RequestBody RegUsers user) {
		try {
			System.out.println("AES value =>"+AESKey);
			if (user!=null &&(user.getTempRoleId()!=0)) {
				user.setPasswd(user.getPlainPasswd());
				user=userService.createUser(user);
				Role role = getRoleService().getRoleById(user.getTempRoleId());
				UserRoles userRole=new UserRoles();
				userRole.setCreated(new Date());
				userRole.setRole(role);
				logger.info("User Created is :"+userRole.getUserRoleId()+" Role Id is :"+role.getRoleName());
				userRole.setRegUsers(user);
				userRoleService.createUserRole(userRole);				
				return user;
			}
		} catch (Exception exception) {
			exception.printStackTrace();		
		}
		return user;

	}

	@ApiOperation(value = "Get a User based on user id", 
			notes = "Get a single User for input id ", response = Role.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	RegUsers getRegisteredUser(@PathVariable("id") long id) {
		RegUsers user = null;
		try {
			user = userService.getUserById(id);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return user;
	}

	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public @ResponseBody
	List<RegUsers> getEmployee() {

		List<RegUsers> userList = null;
		try {
			userList = userService.getUserList();

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return userList;
	}
	@ApiOperation(value = "Delete a User based on user id", 
			notes = "Delete a single User i.e. it changes its 'deleted' flag to true ", response = Role.class)
	@RequestMapping(value = "deleteuser/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteEmployee(@PathVariable("id") long id) {

		Status status=null;
		try {
			status = userService.deleteUser(id);
			return status;
		} catch (Exception exception) {
			exception.printStackTrace();
			return status;

		}

	}


	@RequestMapping(value = "roletouser/{userid}", method = RequestMethod.GET)
	public @ResponseBody
	List<Role> getRoleAssignedToUser(@PathVariable("userid") long userId) {
		List<Role> userAssignedRoleList=new LinkedList<Role>();

		try {
			if (userService.isUserValid(userId)) {

				userAssignedRoleList = userService
						.getRoleAssignedToUser(userId);

				return userAssignedRoleList;
			}
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/greeting/{param}", method = RequestMethod.GET)
	public @ResponseBody
	String getGreeting(@PathVariable("param") String param) {

		return "Hello, param!";
	}

	@RequestMapping(value = "/greetingJohn", method = RequestMethod.GET)
	public @ResponseBody
	String getGreeting() {

		return "Hello, Johan!";
	}
}
