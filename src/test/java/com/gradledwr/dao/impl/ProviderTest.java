package com.gradledwr.dao.impl;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gradledwr.dao.ProviderDAO;
import com.gradledwr.domain.Provider;

public class ProviderTest {

	ProviderDAO dao = null;

	@Before
	public void before() {
		dao = new ProviderDaoImpl();
	}

	@After
	public void after() {
		dao = null;
	}

	@Test
	public void testDAONotNull() {
		Assert.assertNotNull(dao);
	}

	@Test
	public void testProvider() {
		List<Provider> providers = dao.getAllProviders();
		Assert.assertEquals(true, providers.size() > 0);
	}

	@Test
	public void testProviderByName() {
		List<Provider> providers = dao.getProviderByName("AAFFF");
		Assert.assertEquals(true, providers.size() > 0);
	}
}
