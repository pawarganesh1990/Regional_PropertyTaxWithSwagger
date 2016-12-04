package com.regional.property.controllerSolrRest;

import java.util.Date;

import io.swagger.annotations.Api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.regional.property.model.RegUsers;
import com.regional.property.model.Role;
import com.regional.property.model.UserRoles;

@Controller
@RequestMapping("SolrTest")
@Api(value = "This controller will deal with Solr Test Modules")
public class SolrControllerTest {

	@RequestMapping(value = "/testsolrservice", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody
	Void createUser(@RequestBody RegUsers user) {
		try {
			System.out.println("------Test Solr Service is called-----");

		} catch (Exception exception) {
			exception.printStackTrace();		
		}
		return null;
	}
}
