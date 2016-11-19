package com.regional.property.dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.regional.property.dao.RegisterUserDao;
import com.regional.property.model.RegUsers;
import com.regional.property.model.Role;
import com.regional.property.model.Status;
import com.regional.property.model.UserRoles;

@Repository("userDao")
public class RegisterUserDaoImpl implements RegisterUserDao {
	static final Logger logger = Logger.getLogger(RegisterUserDaoImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public RegUsers createUser(RegUsers user) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		int userId=(Integer) session.getIdentifier(user);
		return getUserById(userId);
	}

	@Override
	public RegUsers getUserById(long id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		RegUsers regUser = (RegUsers) session.get(RegUsers.class,new Long(id).intValue());
		return regUser;
	}

	@Override
	public List<RegUsers> getUserList() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(RegUsers.class);
		List<RegUsers> userList = criteria.list();
		return  userList;
	}

	@Override
	public Status deleteUser(long id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		RegUsers regUser = getUserById(id);
		if (regUser!=null) {
			regUser.setDeleted(1);
		}
		session.saveOrUpdate(regUser);
		return new Status(1, "User with userId "+id+" is deleted ");
	}

	@Override
	public List<Role> getRoleAssignedToUser(long userId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(UserRoles.class);

		//criteria.add(Restrictions.eq("regUsers.userId", Long.parseLong(String.valueOf(userId))));
		criteria.add(Restrictions.eq("regUsers.userId", userId));

		List<UserRoles> userList = criteria.list();
		List<Role> roleList=getRolesFromUserRole(userList);
		if (!CollectionUtils.isEmpty(roleList)) {
			return roleList;
		}
		return null;
	}

	/*Method will return roleList from UserRole List Provided*/
	private List<Role> getRolesFromUserRole(List<UserRoles> userRoleList) {
		List<Role> roleList=new ArrayList<Role>();
		if (userRoleList!=null && userRoleList.size()>0) {
			for (UserRoles userRole : userRoleList) {
				roleList.add(userRole.getRole());
			}
			return roleList;
		}
		return null;
	}


	/*Method will return UserList from UserRole List Provided*/
	private List<RegUsers> getUsersFromUserRole(List<UserRoles> userRoleList) {
		List<RegUsers> userList=new ArrayList<RegUsers>();
		if (userRoleList!=null && userRoleList.size()>0) {
			for (UserRoles userRole : userRoleList) {
				userList.add(userRole.getRegUsers());
			}
			return userList;
		}
		return null;
	}

	@Override
	public boolean isUserValid(long userId) throws Exception {
		if (getUserById(userId)!=null) {
			return true;
		}		return false;
	}


}
