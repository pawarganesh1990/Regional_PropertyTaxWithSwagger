package com.regional.property.dao;

import java.util.List;

import com.regional.property.model.RegUsers;
import com.regional.property.model.Role;
import com.regional.property.model.Status;

public interface RegisterUserDao {

	public RegUsers createUser(RegUsers user) throws Exception;

	public RegUsers getUserById(long id) throws Exception;

	public List<RegUsers> getUserList() throws Exception;

	public Status deleteUser(long id) throws Exception;

	public List<Role> getRoleAssignedToUser(long userId);

	public boolean isUserValid(long userId) throws Exception;
}
