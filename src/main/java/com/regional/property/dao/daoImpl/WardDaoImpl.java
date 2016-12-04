package com.regional.property.dao.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.regional.property.dao.WardDao;
import com.regional.property.model.Role;
import com.regional.property.model.Status;
import com.regional.property.model.Ward;
@Repository
public class WardDaoImpl implements WardDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Ward createWard(Ward ward) throws Exception {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(ward);
			int wardId = (Integer) session.getIdentifier(ward);
			return getWardById(wardId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ward;
	}

	@Override
	public Status deleteWard(long id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Ward ward = getWardById(id);
		if (ward!=null) {
			ward.setDeleted(1);
			session.saveOrUpdate(ward);
			return new Status(1, "Ward with roleId "+id+" is deleted ");
		}
		else {
			return new Status(1, "Ward with roleId "+id+" is deleted ");
		}
	}

	@Override
	public List<Ward> getWardList() throws Exception {
		List<Ward> wardList=null;

		try {
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Ward.class);
			wardList = criteria.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wardList;
	}

	@Override
	public Ward getWardById(long id) throws Exception {
		Ward ward=null;
		try {
			Session session = sessionFactory.getCurrentSession();
			ward = (Ward) session.get(Ward.class, new Long(id).intValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ward;
	}

}
