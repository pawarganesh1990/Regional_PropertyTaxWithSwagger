package com.regional.property.dao.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.regional.property.dao.UserRoleDao;
import com.regional.property.model.UserRoles;

@Repository("userRoleDao")
public class UserRoleDaoImpl implements UserRoleDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public UserRoles createUserRole(UserRoles userRole) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(userRole);
			int userRoleId = (Integer) session.getIdentifier(userRole);
			return getUserRoleById(userRoleId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserRoles getUserRoleById(long id) {
		Session session = sessionFactory.getCurrentSession();
		UserRoles userRoles = (UserRoles) session.get(UserRoles.class, new Long(id).intValue());
		return userRoles;
	}

}
