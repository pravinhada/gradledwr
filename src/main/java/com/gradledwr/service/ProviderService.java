package com.gradledwr.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gradledwr.dao.ProviderDAO;
import com.gradledwr.dao.impl.ProviderDaoImpl;
import com.gradledwr.domain.Provider;

public class ProviderService {
	private static Log log = LogFactory.getLog(ProviderService.class);

	private ProviderDAO providerDao = new ProviderDaoImpl();

	public List<Provider> getAllProviders() {
		log.info("Returning all providers.");
		return providerDao.getAllProviders();
	}

	public List<Provider> getProvidersByName(String name) {
		log.info("Returing only " + name + " providers.");
		return providerDao.getProviderByName(name);
	}
}
