package com.regional.property.dao;

import java.util.List;

import com.regional.property.model.Status;
import com.regional.property.model.Ward;

public interface WardDao {
	public Ward createWard(Ward ward) throws Exception;
	public Status deleteWard(long id)throws Exception;
	public List<Ward> getWardList() throws Exception;
	public Ward getWardById(long id)throws Exception;
}
