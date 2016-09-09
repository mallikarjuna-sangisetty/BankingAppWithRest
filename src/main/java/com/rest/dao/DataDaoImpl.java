package com.rest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.rest.model.BankRTable;

public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public BankRTable getEntityById(String id) throws Exception {
		session = sessionFactory.openSession();
		BankRTable bankRTable = (BankRTable) session.get(BankRTable.class,id);
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return bankRTable;
	}

	@Override
	public int saveEntity(BankRTable table) throws Exception {
		session = sessionFactory.openSession();
		session.save(table);
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return 1;
	}

	@Override
	public int updateEntity(BankRTable table) throws Exception {
		session = sessionFactory.openSession();
		session.update(table);
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return 1;
	}

	@Override
	public int deleteEntity(BankRTable table) throws Exception {
		session = sessionFactory.openSession();
		session.delete(table);
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return 1;
	}
}
