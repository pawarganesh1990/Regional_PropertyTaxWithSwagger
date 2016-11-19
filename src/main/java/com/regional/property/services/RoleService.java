package com.regional.property.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.regional.property.model.Role;
import com.regional.property.model.Status;
@Service
public interface RoleService {

	public Role createRole(Role role) throws Exception;
	public Status deleteRole(long id)throws Exception;
	public List<Role> getRoleList() throws Exception;
	public Role getRoleById(long id)throws Exception;

}
