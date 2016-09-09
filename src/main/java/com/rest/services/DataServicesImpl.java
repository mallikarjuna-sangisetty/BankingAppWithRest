package com.rest.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.rest.dao.DataDao;
import com.rest.model.BankRTable;

public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;

	@Override
	public BankRTable getEntityById(String id) throws Exception {
		return dataDao.getEntityById(id);
	}

	@Override
	public int saveEntity(BankRTable table) throws Exception {
		return dataDao.saveEntity(table);
	}

	@Override
	public int updateEntity(BankRTable table) throws Exception {
		return dataDao.updateEntity(table);
	}

	@Override
	public int deleteEntity(BankRTable table) throws Exception {
		return dataDao.deleteEntity(table);
	}
}
