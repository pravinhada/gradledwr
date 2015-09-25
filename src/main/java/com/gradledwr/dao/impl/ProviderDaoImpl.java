package com.test.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import com.test.dao.ProviderDAO;
import com.test.domain.Provider;
import com.test.factory.HibernateSessionFactory;

public class ProviderDaoImpl implements ProviderDAO {

	private static Log log = LogFactory.getLog(ProviderDaoImpl.class);

	@Override
	@SuppressWarnings("unchecked")
	public List<Provider> getAllProviders() {
		Session session = HibernateSessionFactory.getCurrentSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		Query q = session.getNamedQuery("Provider.getAllProvider");
		log.info("returning all the providers.");
		return (List<Provider>) q.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Provider> getProviderByName(String name) {
		Session session = HibernateSessionFactory.getCurrentSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		Query q = session.getNamedQuery("Provider.getProviderByName");
		q.setParameter("name", name);
		return (List<Provider>) q.list();
	}
}
