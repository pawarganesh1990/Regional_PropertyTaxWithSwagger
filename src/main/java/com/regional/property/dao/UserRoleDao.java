package com.regional.property.dao;

import com.regional.property.model.UserRoles;

public interface UserRoleDao {

	public UserRoles createUserRole(UserRoles userRole);
	public UserRoles getUserRoleById(long id) throws Exception;

}
