package com.regional.property.services.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regional.property.dao.WardDao;
import com.regional.property.model.Status;
import com.regional.property.model.Ward;
import com.regional.property.services.WardService;

@Service
@Transactional
public class WardServiceImpl implements WardService {
	@Autowired
	WardDao wardDao;


	public WardDao getWardDao() {
		return wardDao;
	}

	public void setWardDao(WardDao wardDao) {
		this.wardDao = wardDao;
	}

	@Override
	@Transactional
	public Ward createWard(Ward ward) throws Exception {
		// TODO Auto-generated method stub
		return wardDao.createWard(ward);
	}

	@Override
	public Status deleteWard(long id) throws Exception {
		// TODO Auto-generated method stub
		return wardDao.deleteWard(id);
	}

	@Override
	public List<Ward> getWardList() throws Exception {
		return wardDao.getWardList();
	}

	@Override
	public Ward getWardById(long id) throws Exception {
		return wardDao.getWardById(id);
	}

}
