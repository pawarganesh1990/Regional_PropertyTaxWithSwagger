package com.regional.property.services.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regional.property.dao.RoleDao;
import com.regional.property.model.Role;
import com.regional.property.model.Status;
import com.regional.property.services.RoleService;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;


	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	@Transactional
	public Role createRole(Role role) throws Exception {
		return roleDao.createRole(role);
	}

	@Override
	@Transactional
	public Status deleteRole(long id) throws Exception{
		return roleDao.deleteRole(id);

	}

	@Override
	@Transactional
	public List<Role> getRoleList() throws Exception{
		// TODO Auto-generated method stub
		return roleDao.getRoleList();
	}

	@Override
	@Transactional
	public Role getRoleById(long id) throws Exception{
		// TODO Auto-generated method stub
		return roleDao.getRoleById(id);
	}

}
