package com.rest.dao;

import com.rest.model.BankRTable;

public interface DataDao {

	public BankRTable getEntityById(String id) throws Exception;
	public int saveEntity(BankRTable table) throws Exception;
	public int updateEntity(BankRTable table) throws Exception;
	public int deleteEntity(BankRTable table) throws Exception;
}
