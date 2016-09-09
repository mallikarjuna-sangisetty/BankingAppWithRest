package com.rest.services;

import com.rest.model.BankRTable;


public interface DataServices {
	public BankRTable getEntityById(String id) throws Exception;
	public int saveEntity(BankRTable table) throws Exception;
	public int updateEntity(BankRTable table) throws Exception;
	public int deleteEntity(BankRTable table)throws Exception;
}
