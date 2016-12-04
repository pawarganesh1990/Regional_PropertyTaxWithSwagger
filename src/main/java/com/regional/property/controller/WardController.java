package com.regional.property.controller;

import java.util.List;

import javax.print.attribute.standard.Media;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jayway.restassured.internal.http.Method;
import com.regional.property.model.Role;
import com.regional.property.model.Status;
import com.regional.property.model.Ward;
import com.regional.property.services.WardService;

@Controller
@RequestMapping(value="ward")
public class WardController {
	private static final Logger logger = Logger.getLogger(RoleController.class);

	@Autowired
	private WardService wardService;

	public WardService getWardService() {
		return wardService;
	}

	public void setWardService(WardService wardService) {
		this.wardService = wardService;
	}

	@RequestMapping(value = "/createward", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	private @ResponseBody Ward createWard(@RequestBody Ward ward) {

		try {
			ward=getWardService().createWard(ward);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ward;
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Ward getWard(@PathVariable("id") long id) {
		Ward ward = null;
		try {
			ward = getWardService().getWardById(id);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(exception);
		}
		return ward;
	}

	@RequestMapping(value = "/wardlist", method = RequestMethod.GET)
	public @ResponseBody
	List<Ward> getWardList() {

		List<Ward> wardList = null;
		try {
			wardList = getWardService().getWardList();
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(exception);
		}

		return wardList;
	}

	@RequestMapping(value = "deleteward/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteWard(@PathVariable("id") long id) {

		try {
			getWardService().deleteWard(id);
			return new Status(1, "ward deleted Successfully !");
		} catch (Exception exception) {
			logger.error(exception);
		}
		return null;

	}
}
