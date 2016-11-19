package com.regional.property.services.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regional.property.dao.UserRoleDao;
import com.regional.property.model.UserRoles;
import com.regional.property.services.UserRoleService;

@Service("userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleDao userRoleDao;

	public UserRoleDao getUserRoleDao() {
		return userRoleDao;
	}

	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

	@Override
	@Transactional
	public UserRoles createUserRole(UserRoles userRole) throws Exception {
		return getUserRoleDao().createUserRole(userRole);		
	}

}
