package com.regional.property.dao.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.regional.property.dao.RoleDao;
import com.regional.property.model.Role;
import com.regional.property.model.Status;
import com.regional.property.model.UserRoles;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Role getRoleById(long id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Role role = (Role) session.get(Role.class, new Long(id).intValue());
		Hibernate.initialize(role.getUserRoleses());

		return role;
	}

	@Override
	public List<Role> getRoleList() throws Exception {
		List<Role> roleList = new ArrayList<Role>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Role.class);
			roleList = criteria.list();
			Hibernate.initialize(roleList);

			for (Role role : roleList) 
			{
				Hibernate.initialize(role.getUserRoleses());

				/*for (UserRoles userRole : role.getUserRoleses()) {
					Hibernate.initialize(userRole);

				}*/
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  roleList;
	}

	@Override
	public Role createRole(Role role)  {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(role);
			int roleId = (Integer) session.getIdentifier(role);
			return getRoleById(roleId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public Status deleteRole(long id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Role role = getRoleById(id);
		if (role!=null) {
			role.setDeleted(1);
			session.saveOrUpdate(role);
			return new Status(1, "Role with roleId "+id+" is deleted ");
		}
		else {
			return new Status(1, "Role with roleId "+id+" is deleted ");
		}
	}

}
