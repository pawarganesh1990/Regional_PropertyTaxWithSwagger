package com.regional.property.dao;

import java.util.List;

import com.regional.property.model.Role;
import com.regional.property.model.Status;

public interface RoleDao {

	public Role getRoleById(long id) throws Exception;

	public List<Role> getRoleList()throws Exception;

	public Role createRole(Role role)throws Exception;

	public Status deleteRole(long id)throws Exception;

}
